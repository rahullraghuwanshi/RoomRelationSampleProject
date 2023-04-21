package com.rahulraghuwanshi.roommultirelationsampleproject.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahulraghuwanshi.roommultirelationsampleproject.db.dao.QuestionDao
import com.rahulraghuwanshi.roommultirelationsampleproject.db.dao.QuestionDataDao
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.Question
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.QuestionData

@Database(entities = [Question::class, QuestionData::class], version = 1)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun questionDataDao(): QuestionDataDao
}