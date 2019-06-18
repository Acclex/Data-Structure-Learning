package com.acclex.leetcodetopic.sort

import android.util.Log

/**
 * Created by Acclex on 2019/6/13
 * Copyright acclex804199558@gmail.com
 */
fun mergeSort(array: IntArray, size: Int) {
    mergeSortInternally(array, 0, size - 1)
}

private fun mergeSortInternally(array: IntArray, p: Int, r: Int) {
    if (p >= r) return
    val q = p + (r - p) / 2;
    mergeSortInternally(array, p, q)
    mergeSortInternally(array, q + 1, r)
    merge(array, p, q, r)
}

private fun merge(array: IntArray, p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var k = 0
    val tmp = IntArray(r - p + 1) // 申请一个大小跟a[p...r]一样的临时数组
    while (i <= q && j <= r) {
        if (array[i] <= array[j]) {
            tmp[k++] = array[i++] // i++等于i:=i+1
        } else {
            tmp[k++] = array[j++]
        }
    }

    // 判断哪个子数组中有剩余的数据
    var start = i
    var end = q
    if (j <= r) {
        start = j
        end = r
    }

    // 将剩余的数据拷贝到临时数组tmp
    while (start <= end) {
        tmp[k++] = array[start++]
    }
    // 将tmp中的数组拷贝回a[p...r]
    i = 0
    while (i <= r - p) {
        array[p + i] = tmp[i]
        i++
    }
}

fun quickSort(array: IntArray, size: Int) {
    quickSortInternally(array, 0, size - 1)
}

private fun quickSortInternally(array: IntArray, p: Int, r: Int) {
    if (p >= r) return
    val q = partition(array, p, r) // 获取分区点
    quickSortInternally(array, p, q - 1)
    quickSortInternally(array, q + 1, r)
}

private fun partition(array: IntArray, p: Int, r: Int): Int {
    val pivot = array[r]
    var i = p
    for (j in p until r) {
        if (array[j] < pivot) {
            if (i == j) {
                i++
            } else {
                val tmp = array[i]
                array[i++] = array[j]
                array[j] = tmp
            }
        }
    }
    val tmp = array[i]
    array[i] = array[r]
    array[r] = tmp

    Log.d("jw", "i = $i")
    return i
}