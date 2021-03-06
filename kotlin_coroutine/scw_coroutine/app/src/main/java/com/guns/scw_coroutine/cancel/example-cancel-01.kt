/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from cancellation-and-timeouts.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleCancel01

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion 
    println("main: Now I can quit.")
}

/**
 * 안드로이드 스튜디오 상단의 app 상자에서 Edit Configurations 실행 후
 * VM options: 에 아래 옵션을 넣으면 어느 coroutine에서 실행했는지 알 수 있음.
 * -Dkotlinx.coroutines.debug
 */
private fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
