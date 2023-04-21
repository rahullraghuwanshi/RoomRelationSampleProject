package com.rahulraghuwanshi.roommultirelationsampleproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.Question
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.QuestionWithData

@Dao
interface QuestionDao {
    @Insert
    suspend fun insertQuestion(question: Question)

    @Query("SELECT * FROM biology WHERE unique_id = :questionId")
    fun getQuestionById(questionId: Int): QuestionWithData

    @Transaction
    @Query("SELECT * FROM biology")
    fun getQuestionWithData(): List<QuestionWithData>
}