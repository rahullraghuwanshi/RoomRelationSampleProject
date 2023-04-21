package com.rahulraghuwanshi.roommultirelationsampleproject.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "biology")
data class Question(
    @PrimaryKey
    var unique_id: Int = 0,
    var question: String? = null,
    var answer: String? = null,
    var explanation: String? = null,
    var topic_name: String? = null,
    var difficulty_level: Int? = null,
    var option_a: String? = null,
    var option_b: String? = null,
    var option_c: String? = null,
    var option_d: String? = null,
    var card_type: String? = null,
    var quiz_type: String? = null
)