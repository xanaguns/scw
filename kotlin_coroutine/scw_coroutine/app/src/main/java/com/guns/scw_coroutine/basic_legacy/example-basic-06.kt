/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from basics.md by Knit tool. Do not edit.
package com.guns.scw_coroutine.basic_legacy

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope { // Creates a coroutine scope
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}

/**
 * 안드로이드 스튜디오 상단의 app 상자에서 Edit Configurations 실행 후
 * VM options: 에 아래 옵션을 넣으면 어느 coroutine에서 실행했는지 알 수 있음.
 * -Dkotlinx.coroutines.debug
 */
private fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}