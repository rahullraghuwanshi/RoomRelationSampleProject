package com.rahulraghuwanshi.roommultirelationsampleproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.Question
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.QuestionData

@Dao
interface QuestionDataDao {
    @Insert
    suspend fun insertQuestion(questionData: QuestionData)
}