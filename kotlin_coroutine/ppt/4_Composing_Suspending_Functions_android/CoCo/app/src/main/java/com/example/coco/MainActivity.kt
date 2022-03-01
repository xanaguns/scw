package com.example.coco

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()

        button_coroutines.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                runDreamCode()
            }
        }

        button_blocking.setOnClickListener {
            runBlocking {
                runDreamCode()
            }
        }
    }

    private suspend fun runDreamCode() {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()      // val user = fetchUserData() (Network I/O)
            val two = doSomethingUsefulTwo()      // cacheUserData(user) (Database I/O)
            println("The answer is ${one + two}") // textView.text = user.name (update ui)
        }
        println("Completed in $time ms")
    }

    private suspend fun doSomethingUsefulOne(): Int {
        println("start> doSomethingUsefulOne 1")
        delay(20000L)
        println("end> doSomethingUsefulOne 1")
        return 13
    }

    private suspend fun doSomethingUsefulTwo(): Int {
        println("start> doSomethingUsefulTwo 2")
        delay(20000L)
        println("end> doSomethingUsefulTwo 2")
        return 29
    }

    private fun <T>println(msg: T) {
        val log = "$msg [${Thread.currentThread().name}]"
        runOnUiThread {
            text_view.append("\n$log")
        }

        Log.d("TEST", log)
    }

    private fun initUi() {
        button_clear.setOnClickListener {
            text_view.text = ""
        }

        progressBar1.max = 100
        progressBar2.max = 200
        progressBar3.max = 300

        GlobalScope.launch {
            while (isActive) {
                delay(10)

                var progress = progressBar1.progress + 1
                if (progress > progressBar1.max) { progress = 0 }
                progressBar1.progress = progress

                progress = progressBar2.progress + 1
                if (progress > progressBar2.max) { progress = 0 }
                progressBar2.progress = progress

                progress = progressBar3.progress + 1
                if (progress > progressBar3.max) { progress = 0 }
                progressBar3.progress = progress
            }
        }
    }
}