package com.kuit.kuit6android.extension

fun String.toDateFormat() : String {
    val parts = this.split("-")
    val month = parts[0]
    val day = parts[1]
    val week = parts[2]
    return "${month}월 ${day}일 ($week)"
}
