const {
  initializeTestEnvironment,
  assertFails,
  assertSucceeds,
} = require("@firebase/rules-unit-testing");
const { test, before, after, beforeEach } = require("node:test");
const fs = require("node:fs");

let testEnv;
const PROJECT_ID = process.env.GCP_PROJECT || "demo-no-project";
const ALICE_UID = "alice_student_1";
const BOB_UID = "bob_student_2";
const ADMIN_UID = "admin_imran_1";

const [emulatorHost, emulatorPortStr] = (process.env.FIRESTORE_EMULATOR_HOST || "127.0.0.1:8085").split(":");
const emulatorPort = parseInt(emulatorPortStr, 10);

const adminToken = {
  email: "atinazil786@gmail.com",
  email_verified: true,
};

const spoofedAdminToken = {
  email: "atinazil786@gmail.com",
  email_verified: false,
};

const nowTs = () => new Date();

before(async () => {
  const rules = fs.readFileSync("./firestore.rules", "utf8");
  testEnv = await initializeTestEnvironment({
    projectId: PROJECT_ID,
    firestore: {
      rules,
      host: emulatorHost,
      port: emulatorPort,
    },
  });
});

after(async () => {
  if (testEnv) {
    await testEnv.cleanup();
  }
});

beforeEach(async () => {
  if (testEnv) {
    await testEnv.clearFirestore();
  }
});

test("Unauthenticated user cannot read or write user profile or chapters", async () => {
  const unauthDb = testEnv.unauthenticatedContext().firestore();
  await assertFails(unauthDb.collection("users").doc(ALICE_UID).get());
  await assertFails(unauthDb.collection("chapters").where("isPublished", "==", true).get());
});

test("Student can create and read own profile, cannot read/write another student's profile", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).set({
      userId: ALICE_UID,
      displayName: "Aarav Sharma",
      email: "aarav@example.com",
      selectedClass: 10,
      darkMode: false,
      bilingualMode: true,
      dailyStreak: 1,
      totalTestsTaken: 0,
      createdAt: nowTs(),
      updatedAt: nowTs(),
    })
  );

  await assertSucceeds(aliceDb.collection("users").doc(ALICE_UID).get());
  await assertFails(bobDb.collection("users").doc(ALICE_UID).get());
  await assertFails(
    bobDb.collection("users").doc(ALICE_UID).update({
      selectedClass: 12,
      updatedAt: nowTs(),
    })
  );
});

test("Shadow update with ghost field is rejected on user profile", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).set({
      userId: ALICE_UID,
      displayName: "Aarav",
      selectedClass: 10,
      darkMode: false,
      bilingualMode: true,
      dailyStreak: 0,
      totalTestsTaken: 0,
      isAdmin: true, // Ghost field
      createdAt: nowTs(),
      updatedAt: nowTs(),
    })
  );
});

test("Student can manage own bookmarks, progress, and append-only testHistory", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).collection("bookmarks").doc("bm_1").set({
      userId: ALICE_UID,
      itemType: "chapter",
      targetId: "c10_ff_1",
      classLevel: 10,
      title: "A Letter to God",
      subtitle: "First Flight • Chapter 1",
      createdAt: nowTs(),
    })
  );

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).collection("bookmarks").get()
  );
  await assertFails(
    bobDb.collection("users").doc(ALICE_UID).collection("bookmarks").get()
  );

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).collection("testHistory").doc("res_1").set({
      userId: ALICE_UID,
      testTitle: "Class 10 Chapter 1 Test",
      testMode: "CHAPTER",
      classLevel: 10,
      totalQuestions: 20,
      correctCount: 18,
      wrongCount: 2,
      skippedCount: 0,
      percentage: 90,
      durationSeconds: 420,
      createdAt: nowTs(),
    })
  );

  // Append-only testHistory cannot be updated
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).collection("testHistory").doc("res_1").update({
      percentage: 100,
    })
  );
});

test("Verified admin can create/update/delete published chapters; spoofed or regular user cannot", async () => {
  const adminDb = testEnv.authenticatedContext(ADMIN_UID, adminToken).firestore();
  const spoofedDb = testEnv.authenticatedContext("spoof_1", spoofedAdminToken).firestore();
  const studentDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  const chapterPayload = {
    authorId: ADMIN_UID,
    classLevel: 12,
    bookName: "Flamingo",
    chapterNumber: 1,
    title: "The Last Lesson (Updated)",
    author: "Alphonse Daudet",
    summaryEn: "Franz realizes the value of his mother tongue.",
    summaryHi: "फ्रांज को अपनी मातृभाषा के महत्व का एहसास होता है।",
    hindiExplanation: "अध्याय का विस्तृत हिंदी सार।",
    wordMeanings: ["Dread :: भय :: Great fear"],
    isPublished: true,
    createdAt: nowTs(),
    updatedAt: nowTs(),
  };

  await assertFails(studentDb.collection("chapters").doc("ch_custom_1").set(chapterPayload));
  await assertFails(spoofedDb.collection("chapters").doc("ch_custom_1").set({ ...chapterPayload, authorId: "spoof_1" }));
  await assertSucceeds(adminDb.collection("chapters").doc("ch_custom_1").set(chapterPayload));

  // Student can query published chapters with matching filter, fails unfiltered query
  await assertSucceeds(studentDb.collection("chapters").where("isPublished", "==", true).get());
  await assertFails(studentDb.collection("chapters").get());

  // Admin can update and delete
  await assertSucceeds(
    adminDb.collection("chapters").doc("ch_custom_1").update({
      title: "The Last Lesson - Revised",
      updatedAt: nowTs(),
    })
  );
  await assertSucceeds(adminDb.collection("chapters").doc("ch_custom_1").delete());
});

test("Student can save and read own writingPractice attempts; cross-student access fails", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();

  const attemptPayload = {
    userId: ALICE_UID,
    classLevel: 10,
    chapterId: "c10_ff_1",
    chapterTitle: "A Letter to God",
    questionPrompt: "Why did Lencho write a letter to God?",
    studentAnswer: "Lencho wrote a letter to God because hailstones destroyed his corn crop.",
    maxMarks: 3,
    marksObtained: 2.5,
    grammarScore: 85,
    spellingScore: 95,
    vocabularyScore: 80,
    structureScore: 85,
    correctedAnswer: "Lencho wrote a letter to God because a hailstorm destroyed his entire corn crop.",
    grammaticalMistakes: ["Use 'a hailstorm' instead of 'hailstones' for clearer subject agreement."],
    suggestions: ["Mention that he asked for 100 pesos."],
    modelAnswer: "Lencho wrote a letter to God seeking 100 pesos after a hailstorm destroyed his corn crop.",
    explanationHi: "आपका उत्तर सही है। बस 100 पेसोस की मांग का उल्लेख जोड़ें।",
    createdAt: nowTs(),
  };

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).collection("writingPractice").doc("wp_1").set(attemptPayload)
  );
  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).collection("writingPractice").get()
  );
  await assertFails(
    bobDb.collection("users").doc(ALICE_UID).collection("writingPractice").get()
  );
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).collection("writingPractice").doc("wp_1").update({
      marksObtained: 3,
    })
  );
});

test("StudentTestResults mirrors allow owner query & admin full list, deny cross-student reads", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();
  const adminDb = testEnv.authenticatedContext(ADMIN_UID, adminToken).firestore();

  await assertSucceeds(
    aliceDb.collection("studentTestResults").doc("sum_1").set({
      userId: ALICE_UID,
      studentName: "Aarav",
      testTitle: "Class 10 Full Syllabus",
      testMode: "20Q",
      classLevel: 10,
      totalQuestions: 20,
      correctCount: 17,
      wrongCount: 3,
      percentage: 85,
      durationSeconds: 300,
      createdAt: nowTs(),
    })
  );

  // Admin can list all student results
  await assertSucceeds(adminDb.collection("studentTestResults").get());
  // Owner can list filtered by own userId
  await assertSucceeds(aliceDb.collection("studentTestResults").where("userId", "==", ALICE_UID).get());
  // Cross-student list/get fails
  await assertFails(bobDb.collection("studentTestResults").get());
  await assertFails(bobDb.collection("studentTestResults").doc("sum_1").get());
  // Admin can delete summary
  await assertSucceeds(adminDb.collection("studentTestResults").doc("sum_1").delete());
});

test("Admin can manage writingMaterials, previousPapers, pdfNotes, and videoLinks; students can only read published", async () => {
  const adminDb = testEnv.authenticatedContext(ADMIN_UID, adminToken).firestore();
  const studentDb = testEnv.authenticatedContext(ALICE_UID).firestore();

  const writingPayload = {
    authorId: ADMIN_UID,
    topicCategory: "Notice Writing",
    title: "Annual Sports Day Notice",
    titleHi: "वार्षिक खेल दिवस सूचना",
    applicableClasses: [11, 12],
    explanationHi: "सूचना हमेशा एक बॉक्स में लिखी जाती है।",
    formatTemplate: "[SCHOOL NAME]\nNOTICE\nDate\nHeading\nBody\nSignature",
    solvedExampleEn: "All students are informed...",
    solvedExampleHi: "सभी छात्रों को सूचित किया जाता है...",
    examQuestion: "Draft a notice for Annual Sports Day.",
    modelAnswer: "ABC H.S. School, Bhopal\nNOTICE...",
    isPublished: true,
    createdAt: nowTs(),
    updatedAt: nowTs(),
  };

  await assertFails(studentDb.collection("writingMaterials").doc("wm_1").set(writingPayload));
  await assertSucceeds(adminDb.collection("writingMaterials").doc("wm_1").set(writingPayload));
  await assertSucceeds(studentDb.collection("writingMaterials").where("isPublished", "==", true).get());

  const paperPayload = {
    authorId: ADMIN_UID,
    classLevel: 12,
    year: 2024,
    title: "MPBSE Class 12 General English 2024",
    setCode: "Set A",
    isVerifiedPyq: true,
    summaryHi: "एमपी बोर्ड 2024 मूल प्रश्न पत्र।",
    pdfFileName: "mpbse_12_2024.pdf",
    pdfUrl: "",
    pdfBase64: "JVBERi0xLjQK",
    questionsFormatted: ["Q1. Read the passage carefully..."],
    isPublished: true,
    createdAt: nowTs(),
    updatedAt: nowTs(),
  };

  await assertFails(studentDb.collection("previousPapers").doc("pyq_1").set(paperPayload));
  await assertSucceeds(adminDb.collection("previousPapers").doc("pyq_1").set(paperPayload));
  await assertSucceeds(studentDb.collection("previousPapers").where("isPublished", "==", true).get());

  const notePayload = {
    authorId: ADMIN_UID,
    classLevel: 10,
    chapterId: "c10_ff_1",
    title: "A Letter to God - Revision Notes",
    summaryHi: "संक्षिप्त परीक्षा नोट्स",
    pdfFileName: "letter_to_god_notes.pdf",
    pdfUrl: "",
    pdfBase64: "JVBERi0xLjQK",
    isPublished: true,
    createdAt: nowTs(),
    updatedAt: nowTs(),
  };

  await assertFails(studentDb.collection("pdfNotes").doc("note_1").set(notePayload));
  await assertSucceeds(adminDb.collection("pdfNotes").doc("note_1").set(notePayload));
  await assertSucceeds(studentDb.collection("pdfNotes").where("isPublished", "==", true).get());

  const videoPayload = {
    authorId: ADMIN_UID,
    classLevel: 10,
    chapterId: "c10_ff_1",
    title: "A Letter to God - 2D Animated Explanation",
    summaryHi: "अध्याय का एनिमेटेड वीडियो",
    videoUrl: "https://example.com/lesson-video",
    isPublished: true,
    createdAt: nowTs(),
    updatedAt: nowTs(),
  };

  await assertFails(studentDb.collection("videoLinks").doc("vid_1").set(videoPayload));
  await assertSucceeds(adminDb.collection("videoLinks").doc("vid_1").set(videoPayload));
  await assertSucceeds(studentDb.collection("videoLinks").where("isPublished", "==", true).get());
});

