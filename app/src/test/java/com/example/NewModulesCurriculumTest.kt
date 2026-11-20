package com.example

import com.example.data.curriculum.PreviousYearPapersCurriculum
import com.example.data.curriculum.WritingSkillsCurriculum
import com.example.data.model.MarkingSchemeOption
import com.example.data.model.PyqSectionType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class NewModulesCurriculumTest {

    @Test
    fun writingSkillsCurriculum_containsAll15RequiredTopicsWithBilingualContent() {
        val topics = WritingSkillsCurriculum.topics
        assertEquals(15, topics.size)

        val expectedKeywords = listOf(
            "Note Making",
            "Formal Application Writing",
            "Informal Letter Writing",
            "Formal Letter Writing",
            "Notice Writing",
            "Poster Making",
            "Advertisement Writing",
            "Picture Composition",
            "Report Writing",
            "Article Writing",
            "Speech Writing",
            "Paragraph Writing",
            "Essay Writing",
            "Invitation Writing",
            "Message Writing"
        )

        expectedKeywords.forEachIndexed { idx, expected ->
            val topic = topics[idx]
            assertEquals(idx + 1, topic.order)
            assertTrue("Missing topic $expected", topic.titleEn.contains(expected, ignoreCase = true))
            assertTrue("${topic.titleEn} needs Hindi title", topic.titleHi.isNotBlank())
            assertTrue("${topic.titleEn} needs Hindi explanation", topic.explanationHi.length > 30)
            assertTrue("${topic.titleEn} needs rules", topic.rulesAndFormatEn.isNotEmpty())
            assertTrue("${topic.titleEn} needs format template", topic.formatTemplate.isNotBlank())
            assertTrue("${topic.titleEn} needs steps in Hindi", topic.stepsHi.isNotEmpty())
            assertTrue("${topic.titleEn} needs solved example", topic.solvedExamples.isNotEmpty())
            assertTrue("${topic.titleEn} needs Hindi explanation for solved example", topic.solvedExamples.first().hindiExplanation.isNotBlank())
            assertTrue("${topic.titleEn} needs exam questions", topic.examQuestionsAndModels.isNotEmpty())
            assertTrue("${topic.titleEn} needs practice exercises", topic.practiceExercises.isNotEmpty())
            assertTrue("${topic.titleEn} needs valid MP Board classes", topic.applicableClasses.all { it in 9..12 })
        }
    }

    @Test
    fun previousYearPapersCurriculum_coversClasses9To12Across2022To2026Honestly() {
        val papers = PreviousYearPapersCurriculum.papers
        assertEquals(20, papers.size)

        val classes = listOf(9, 10, 11, 12)
        val years = listOf(2022, 2023, 2024, 2025, 2026)

        classes.forEach { cls ->
            years.forEach { yr ->
                val paper = papers.firstOrNull { it.classLevel == cls && it.year == yr }
                assertTrue("Missing paper for Class $cls Year $yr", paper != null)
                requireNotNull(paper)
                if (yr == 2026) {
                    assertFalse("2026 paper must NOT claim isVerifiedPyq=true", paper.isVerifiedPyq)
                    assertTrue(
                        "2026 paper should mention Blueprint/Pattern",
                        paper.sourceLabel.contains("Blueprint", ignoreCase = true) ||
                            paper.sourceLabel.contains("Pattern", ignoreCase = true)
                    )
                } else {
                    assertTrue("2022-2025 paper should have isVerifiedPyq=true", paper.isVerifiedPyq)
                }

                val types = paper.questions.map { it.sectionType }.toSet()
                assertTrue("Missing Objective Qs in ${paper.id}", PyqSectionType.OBJECTIVE in types)
                assertTrue("Missing Very Short Qs in ${paper.id}", PyqSectionType.VERY_SHORT in types)
                assertTrue("Missing Short Qs in ${paper.id}", PyqSectionType.SHORT in types)
                assertTrue("Missing Long Qs in ${paper.id}", PyqSectionType.LONG in types)

                paper.questions.forEach { q ->
                    assertTrue("Question needs answerKeyEn in ${paper.id}", q.answerKeyEn.isNotBlank())
                    assertTrue("Question needs modelSolutionEn in ${paper.id}", q.modelSolutionEn.isNotBlank())
                }
            }
        }
    }

    @Test
    fun markingSchemePresets_coverBoardStandards() {
        val marks = MarkingSchemeOption.PRESETS.map { it.maxMarks }
        assertEquals(listOf(2, 3, 4, 5), marks)
    }
}
