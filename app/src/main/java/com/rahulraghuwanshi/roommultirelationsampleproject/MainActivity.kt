package com.rahulraghuwanshi.roommultirelationsampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import com.rahulraghuwanshi.roommultirelationsampleproject.db.database.MyAppDatabase
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.Question
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.QuestionData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDatabase()
    }

    private fun initDatabase() {
        val myAppDatabase =  Room.databaseBuilder(
            applicationContext,
            MyAppDatabase::class.java,
            "myAppDatabase"
        ).build()

        findViewById<Button>(R.id.btn).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                myAppDatabase.questionDao().insertQuestion(Question(1,"qq","ans",
                    "","",1,"",""))
            }
        }

        findViewById<Button>(R.id.insertData).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                myAppDatabase.questionDataDao().insertQuestion(QuestionData(1,1,1,1,1))
            }
        }

        findViewById<Button>(R.id.Get).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val list = myAppDatabase.questionDao().getQuestionWithData()
                Log.d("TAG", "initDatabase: $list")
            }
        }
    }
}