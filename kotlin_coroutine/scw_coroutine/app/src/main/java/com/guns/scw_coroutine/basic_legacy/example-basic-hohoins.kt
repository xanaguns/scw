package com.guns.scw_coroutine.basic_legacy

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        repeat(5) { i ->
            println("Coroutine A, $i")
            delay(10L)
        }
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B, $i")
            delay(10L)
        }
    }

    println("Couroutine Outer")
}


/**
 * 안드로이드 스튜디오 상단의 app 상자에서 Edit Configurations 실행 후
 * VM options: 에 아래 옵션을 넣으면 어느 coroutine에서 실행했는지 알 수 있음.
 * -Dkotlinx.coroutines.debug
 */
private fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}