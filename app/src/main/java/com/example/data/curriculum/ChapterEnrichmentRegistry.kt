package com.example.data.curriculum

import com.example.data.model.Chapter

object ChapterEnrichmentRegistry {

    private val allSpecs: Map<String, ChapterRichSpec> by lazy {
        Class9Enrichment.specs +
            Class10Enrichment.specs +
            Class11Enrichment.specs +
            Class12Enrichment.specs
    }

    fun enrichAll(chapters: List<Chapter>): List<Chapter> {
        return chapters.map { enrichChapter(it) }
    }

    fun enrichChapter(chapter: Chapter): Chapter {
        val spec = allSpecs[chapter.id]
        return ChapterEnrichmentEngine.enrich(chapter, spec)
    }
}
