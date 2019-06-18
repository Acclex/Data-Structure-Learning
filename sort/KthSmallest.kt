package com.acclex.leetcodetopic.sort

/**
 * Created by Acclex on 2019/6/15
 * Copyright acclex804199558@gmail.com
 */

fun kthSmall(array: IntArray, k: Int): Int {
    if (array.size < k) return -1
    var partition = partition(array, 0, array.size - 1)
    while (partition + 1 != k) {
        partition = if (partition + 1 < k) {
            partition(array, partition + 1, array.size - 1)
        } else {
            partition(array, 0, partition - 1)
        }
    }
    return array[partition]
}

private fun partition(array: IntArray, p: Int, r: Int): Int {
    val pivot = array[r]
    var i = p
    for (j in p until r) {
        if (array[j] <= pivot) {
            swap(array, i, j)
            i++
        }
    }
    swap(array, i, r)
    return i
}

private fun swap(array: IntArray, i: Int, j: Int) {
    if (i == j) return

    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}