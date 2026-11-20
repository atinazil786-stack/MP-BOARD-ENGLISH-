package com.example.data.curriculum

import com.example.data.model.Chapter

data class PrescribedUnitSpec(
    val id: String,
    val classLevel: Int,
    val bookName: String,
    val category: String, // "Prose", "Poem", "Supplementary"
    val number: Int,
    val title: String
)

data class ClassInventorySummary(
    val classLevel: Int,
    val booksLabel: String,
    val prescribedProse: Int,
    val prescribedPoems: Int,
    val prescribedSupplementary: Int,
    val loadedProse: Int,
    val loadedPoems: Int,
    val loadedSupplementary: Int
) {
    val prescribedTotal: Int get() = prescribedProse + prescribedPoems + prescribedSupplementary
    val loadedTotal: Int get() = loadedProse + loadedPoems + loadedSupplementary
    val isComplete: Boolean
        get() = loadedProse >= prescribedProse &&
            loadedPoems >= prescribedPoems &&
            loadedSupplementary >= prescribedSupplementary
}

object SyllabusInventory {

    val prescribedUnits: List<PrescribedUnitSpec> = listOf(
        // ==================== CLASS 9: BEEHIVE PROSE (9) ====================
        PrescribedUnitSpec("c9_bh_1", 9, "Beehive", "Prose", 1, "The Fun They Had"),
        PrescribedUnitSpec("c9_bh_2", 9, "Beehive", "Prose", 2, "The Sound of Music"),
        PrescribedUnitSpec("c9_bh_3", 9, "Beehive", "Prose", 3, "The Little Girl"),
        PrescribedUnitSpec("c9_bh_4", 9, "Beehive", "Prose", 4, "A Truly Beautiful Mind"),
        PrescribedUnitSpec("c9_bh_5", 9, "Beehive", "Prose", 5, "The Snake and the Mirror"),
        PrescribedUnitSpec("c9_bh_6", 9, "Beehive", "Prose", 6, "My Childhood"),
        PrescribedUnitSpec("c9_bh_7", 9, "Beehive", "Prose", 7, "Reach for the Top"),
        PrescribedUnitSpec("c9_bh_8", 9, "Beehive", "Prose", 8, "Kathmandu"),
        PrescribedUnitSpec("c9_bh_9", 9, "Beehive", "Prose", 9, "If I Were You"),

        // ==================== CLASS 9: BEEHIVE POEMS (8) ====================
        PrescribedUnitSpec("c9_bh_p1", 9, "Beehive", "Poem", 1, "The Road Not Taken"),
        PrescribedUnitSpec("c9_bh_p2", 9, "Beehive", "Poem", 2, "Wind"),
        PrescribedUnitSpec("c9_bh_p3", 9, "Beehive", "Poem", 3, "Rain on the Roof"),
        PrescribedUnitSpec("c9_bh_p4", 9, "Beehive", "Poem", 4, "The Lake Isle of Innisfree"),
        PrescribedUnitSpec("c9_bh_p5", 9, "Beehive", "Poem", 5, "A Legend of the Northland"),
        PrescribedUnitSpec("c9_bh_p6", 9, "Beehive", "Poem", 6, "No Men Are Foreign"),
        PrescribedUnitSpec("c9_bh_p7", 9, "Beehive", "Poem", 7, "On Killing a Tree"),
        PrescribedUnitSpec("c9_bh_p8", 9, "Beehive", "Poem", 8, "A Slumber Did My Spirit Seal"),

        // ==================== CLASS 9: MOMENTS SUPPLEMENTARY (9) ====================
        PrescribedUnitSpec("c9_mo_1", 9, "Moments", "Supplementary", 1, "The Lost Child"),
        PrescribedUnitSpec("c9_mo_2", 9, "Moments", "Supplementary", 2, "The Adventures of Toto"),
        PrescribedUnitSpec("c9_mo_3", 9, "Moments", "Supplementary", 3, "Iswaran the Storyteller"),
        PrescribedUnitSpec("c9_mo_4", 9, "Moments", "Supplementary", 4, "In the Kingdom of Fools"),
        PrescribedUnitSpec("c9_mo_5", 9, "Moments", "Supplementary", 5, "The Happy Prince"),
        PrescribedUnitSpec("c9_mo_6", 9, "Moments", "Supplementary", 6, "Weathering the Storm in Ersama"),
        PrescribedUnitSpec("c9_mo_7", 9, "Moments", "Supplementary", 7, "The Last Leaf"),
        PrescribedUnitSpec("c9_mo_8", 9, "Moments", "Supplementary", 8, "A House Is Not a Home"),
        PrescribedUnitSpec("c9_mo_9", 9, "Moments", "Supplementary", 9, "The Beggar"),

        // ==================== CLASS 10: FIRST FLIGHT PROSE (9) ====================
        PrescribedUnitSpec("c10_ff_1", 10, "First Flight", "Prose", 1, "A Letter to God"),
        PrescribedUnitSpec("c10_ff_2", 10, "First Flight", "Prose", 2, "Nelson Mandela: Long Walk to Freedom"),
        PrescribedUnitSpec("c10_ff_3", 10, "First Flight", "Prose", 3, "Two Stories about Flying"),
        PrescribedUnitSpec("c10_ff_4", 10, "First Flight", "Prose", 4, "From the Diary of Anne Frank"),
        PrescribedUnitSpec("c10_ff_5", 10, "First Flight", "Prose", 5, "Glimpses of India"),
        PrescribedUnitSpec("c10_ff_6", 10, "First Flight", "Prose", 6, "Mijbil the Otter"),
        PrescribedUnitSpec("c10_ff_7", 10, "First Flight", "Prose", 7, "Madam Rides the Bus"),
        PrescribedUnitSpec("c10_ff_8", 10, "First Flight", "Prose", 8, "The Sermon at Benares"),
        PrescribedUnitSpec("c10_ff_9", 10, "First Flight", "Prose", 9, "The Proposal"),

        // ==================== CLASS 10: FIRST FLIGHT POEMS (10) ====================
        PrescribedUnitSpec("c10_ff_p1", 10, "First Flight", "Poem", 1, "Dust of Snow"),
        PrescribedUnitSpec("c10_ff_p2", 10, "First Flight", "Poem", 2, "Fire and Ice"),
        PrescribedUnitSpec("c10_ff_p3", 10, "First Flight", "Poem", 3, "A Tiger in the Zoo"),
        PrescribedUnitSpec("c10_ff_p4", 10, "First Flight", "Poem", 4, "How to Tell Wild Animals"),
        PrescribedUnitSpec("c10_ff_p5", 10, "First Flight", "Poem", 5, "The Ball Poem"),
        PrescribedUnitSpec("c10_ff_p6", 10, "First Flight", "Poem", 6, "Amanda!"),
        PrescribedUnitSpec("c10_ff_p7", 10, "First Flight", "Poem", 7, "The Trees"),
        PrescribedUnitSpec("c10_ff_p8", 10, "First Flight", "Poem", 8, "Fog"),
        PrescribedUnitSpec("c10_ff_p9", 10, "First Flight", "Poem", 9, "The Tale of Custard the Dragon"),
        PrescribedUnitSpec("c10_ff_p10", 10, "First Flight", "Poem", 10, "For Anne Gregory"),

        // ==================== CLASS 10: FOOTPRINTS WITHOUT FEET SUPPLEMENTARY (9) ====================
        PrescribedUnitSpec("c10_fp_1", 10, "Footprints Without Feet", "Supplementary", 1, "A Triumph of Surgery"),
        PrescribedUnitSpec("c10_fp_2", 10, "Footprints Without Feet", "Supplementary", 2, "The Thief's Story"),
        PrescribedUnitSpec("c10_fp_3", 10, "Footprints Without Feet", "Supplementary", 3, "The Midnight Visitor"),
        PrescribedUnitSpec("c10_fp_4", 10, "Footprints Without Feet", "Supplementary", 4, "A Question of Trust"),
        PrescribedUnitSpec("c10_fp_5", 10, "Footprints Without Feet", "Supplementary", 5, "Footprints Without Feet"),
        PrescribedUnitSpec("c10_fp_6", 10, "Footprints Without Feet", "Supplementary", 6, "The Making of a Scientist"),
        PrescribedUnitSpec("c10_fp_7", 10, "Footprints Without Feet", "Supplementary", 7, "The Necklace"),
        PrescribedUnitSpec("c10_fp_8", 10, "Footprints Without Feet", "Supplementary", 8, "Bholi"),
        PrescribedUnitSpec("c10_fp_9", 10, "Footprints Without Feet", "Supplementary", 9, "The Book That Saved the Earth"),

        // ==================== CLASS 11: HORNBILL PROSE (6) ====================
        PrescribedUnitSpec("c11_hb_1", 11, "Hornbill", "Prose", 1, "The Portrait of a Lady"),
        PrescribedUnitSpec("c11_hb_2", 11, "Hornbill", "Prose", 2, "We're Not Afraid to Die... if We Can All Be Together"),
        PrescribedUnitSpec("c11_hb_3", 11, "Hornbill", "Prose", 3, "Discovering Tut: the Saga Continues"),
        PrescribedUnitSpec("c11_hb_4", 11, "Hornbill", "Prose", 4, "The Ailing Planet: the Green Movement's Role"),
        PrescribedUnitSpec("c11_hb_5", 11, "Hornbill", "Prose", 5, "The Adventure"),
        PrescribedUnitSpec("c11_hb_6", 11, "Hornbill", "Prose", 6, "Silk Road"),

        // ==================== CLASS 11: HORNBILL POEMS (5) ====================
        PrescribedUnitSpec("c11_hb_p1", 11, "Hornbill", "Poem", 1, "A Photograph"),
        PrescribedUnitSpec("c11_hb_p2", 11, "Hornbill", "Poem", 2, "The Laburnum Top"),
        PrescribedUnitSpec("c11_hb_p3", 11, "Hornbill", "Poem", 3, "The Voice of the Rain"),
        PrescribedUnitSpec("c11_hb_p4", 11, "Hornbill", "Poem", 4, "Childhood"),
        PrescribedUnitSpec("c11_hb_p5", 11, "Hornbill", "Poem", 5, "Father to Son"),

        // ==================== CLASS 11: SNAPSHOTS SUPPLEMENTARY (5) ====================
        PrescribedUnitSpec("c11_sn_1", 11, "Snapshots", "Supplementary", 1, "The Summer of the Beautiful White Horse"),
        PrescribedUnitSpec("c11_sn_2", 11, "Snapshots", "Supplementary", 2, "The Address"),
        PrescribedUnitSpec("c11_sn_3", 11, "Snapshots", "Supplementary", 3, "Mother's Day"),
        PrescribedUnitSpec("c11_sn_4", 11, "Snapshots", "Supplementary", 4, "Birth"),
        PrescribedUnitSpec("c11_sn_5", 11, "Snapshots", "Supplementary", 5, "The Tale of Melon City"),

        // ==================== CLASS 12: FLAMINGO PROSE (8) ====================
        PrescribedUnitSpec("c12_fl_1", 12, "Flamingo", "Prose", 1, "The Last Lesson"),
        PrescribedUnitSpec("c12_fl_2", 12, "Flamingo", "Prose", 2, "Lost Spring"),
        PrescribedUnitSpec("c12_fl_3", 12, "Flamingo", "Prose", 3, "Deep Water"),
        PrescribedUnitSpec("c12_fl_4", 12, "Flamingo", "Prose", 4, "The Rattrap"),
        PrescribedUnitSpec("c12_fl_5", 12, "Flamingo", "Prose", 5, "Indigo"),
        PrescribedUnitSpec("c12_fl_6", 12, "Flamingo", "Prose", 6, "Poets and Pancakes"),
        PrescribedUnitSpec("c12_fl_7", 12, "Flamingo", "Prose", 7, "The Interview"),
        PrescribedUnitSpec("c12_fl_8", 12, "Flamingo", "Prose", 8, "Going Places"),

        // ==================== CLASS 12: FLAMINGO POEMS (5) ====================
        PrescribedUnitSpec("c12_fl_p1", 12, "Flamingo", "Poem", 1, "My Mother at Sixty-six"),
        PrescribedUnitSpec("c12_fl_p2", 12, "Flamingo", "Poem", 2, "Keeping Quiet"),
        PrescribedUnitSpec("c12_fl_p3", 12, "Flamingo", "Poem", 3, "A Thing of Beauty"),
        PrescribedUnitSpec("c12_fl_p4", 12, "Flamingo", "Poem", 4, "A Roadside Stand"),
        PrescribedUnitSpec("c12_fl_p5", 12, "Flamingo", "Poem", 5, "Aunt Jennifer's Tigers"),

        // ==================== CLASS 12: VISTAS SUPPLEMENTARY (6) ====================
        PrescribedUnitSpec("c12_vi_1", 12, "Vistas", "Supplementary", 1, "The Third Level"),
        PrescribedUnitSpec("c12_vi_2", 12, "Vistas", "Supplementary", 2, "The Tiger King"),
        PrescribedUnitSpec("c12_vi_3", 12, "Vistas", "Supplementary", 3, "Journey to the End of the Earth"),
        PrescribedUnitSpec("c12_vi_4", 12, "Vistas", "Supplementary", 4, "The Enemy"),
        PrescribedUnitSpec("c12_vi_5", 12, "Vistas", "Supplementary", 5, "On the Face of It"),
        PrescribedUnitSpec("c12_vi_6", 12, "Vistas", "Supplementary", 6, "Memories of Childhood")
    )

    fun summarizeByClass(chapters: List<Chapter>): List<ClassInventorySummary> {
        val booksMap = mapOf(
            9 to "Beehive & Moments",
            10 to "First Flight & Footprints Without Feet",
            11 to "Hornbill & Snapshots",
            12 to "Flamingo & Vistas"
        )
        return listOf(9, 10, 11, 12).map { lvl ->
            val prescribed = prescribedUnits.filter { it.classLevel == lvl }
            val loaded = chapters.filter { it.classLevel == lvl }
            ClassInventorySummary(
                classLevel = lvl,
                booksLabel = booksMap[lvl].orEmpty(),
                prescribedProse = prescribed.count { it.category == "Prose" },
                prescribedPoems = prescribed.count { it.category == "Poem" },
                prescribedSupplementary = prescribed.count { it.category == "Supplementary" },
                loadedProse = loaded.count { it.category == "Prose" },
                loadedPoems = loaded.count { it.category == "Poem" },
                loadedSupplementary = loaded.count { it.category == "Supplementary" }
            )
        }
    }

    fun missingIds(chapters: List<Chapter>): List<PrescribedUnitSpec> {
        val loadedIds = chapters.map { it.id }.toSet()
        return prescribedUnits.filter { it.id !in loadedIds }
    }
}
