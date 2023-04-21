package com.rahulraghuwanshi.roommultirelationsampleproject.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "biology_data")
data class QuestionData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var question_id: Int = 0,
    var nth_review: Int? = null,
    var completed: Int? = null,
    var bookmark: Int? = null
)