package com.acclex.leetcodetopic.sort

/**
 * Created by Acclex on 2019/6/18
 * Copyright acclex804199558@gmail.com
 */
fun countingSort(array: IntArray, size: Int) {
    if (size <= 1) return

    val max: Int = array.max()!!

    // 计数数组C，下标是[0,max]
    val c = IntArray(max + 1)
    for (i in 0 until max + 1) {
        c[i] = 0
    }

    // 计算每个元素的个数，放入c中
    for (i in 0 until size) {
        c[array[i]]++
    }

    // 依次累加
    for (i in 1 until max + 1) {
        c[i] = c[i - 1] + c[i]
    }

    // 临时数组r，存储排序之后的结果
    val r = IntArray(size)
    // 计算排序的关键步骤了，有点难理解
    for (i in size - 1 downTo 0) {
        val index = c[array[i]] - 1
        r[index] = array[i]
        c[array[i]]--
    }

    // 将结果拷贝会a数组
    for (i in 0 until size) {
        array[i] = r[i]
    }
}

// 排序课后习题
fun sortChar(s: String) {
    if (s.isBlank()) return
    val lowerLetters = mutableListOf<Char>()
    val numbers = mutableListOf<Char>()
    val uppercaseLetter = mutableListOf<Char>()

    for (char in s) {
        when {
            Character.isLowerCase(char) -> lowerLetters.add(char)
            Character.isUpperCase(char) -> uppercaseLetter.add(char)
            Character.isDigit(char) -> numbers.add(char)
        }
    }

    val sort = mutableListOf<Char>()
    lowerLetters.forEach { sort.add(it) }
    numbers.forEach { sort.add(it) }
    uppercaseLetter.forEach { sort.add(it) }
}