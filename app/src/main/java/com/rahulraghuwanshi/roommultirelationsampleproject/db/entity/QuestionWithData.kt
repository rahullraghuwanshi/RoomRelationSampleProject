package com.rahulraghuwanshi.roommultirelationsampleproject.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithData(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "unique_id",
        entityColumn = "question_id"
    )
    val questionData: QuestionData
)