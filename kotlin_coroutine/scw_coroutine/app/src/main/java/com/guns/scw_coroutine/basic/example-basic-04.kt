/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic04

import kotlinx.coroutines.*

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

/**
 * 안드로이드 스튜디오 상단의 app 상자에서 Edit Configurations 실행 후
 * VM options: 에 아래 옵션을 넣으면 어느 coroutine에서 실행했는지 알 수 있음.
 * -Dkotlinx.coroutines.debug
 */
private fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
