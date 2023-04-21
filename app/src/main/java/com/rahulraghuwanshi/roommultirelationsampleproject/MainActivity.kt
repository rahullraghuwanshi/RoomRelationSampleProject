package com.rahulraghuwanshi.roommultirelationsampleproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rahulraghuwanshi.roommultirelationsampleproject.db.database.MyAppDatabase
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.Question
import com.rahulraghuwanshi.roommultirelationsampleproject.db.entity.QuestionData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.nio.charset.StandardCharsets

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

        findViewById<Button>(R.id.insertList).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("TAG", "initDatabase: Insertion Start")
                val gson = Gson()
                val que = loadJSONFromAsset("biology.json")
                val model = object : TypeToken<List<Question>>() {}.type
                val list: List<Question> = gson.fromJson(que, model)
                val insertion = async {myAppDatabase.questionDao().insertQuestionLIst(list)
                    true}.await()

                if (insertion) Log.d("TAG", "initDatabase: Insertion End...")
            }
        }
    }
}

//to load json from asset folder
fun Context.loadJSONFromAsset(fileName: String): String? {
    val jsonString: String = try {
        val inputStream = assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, StandardCharsets.UTF_8)
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
    return jsonString
}