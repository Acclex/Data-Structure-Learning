/**
 * Created by Acclex on 2019/6/24
 * Copyright acclex804199558@gmail.com
 */
/**
 * 二分查找的最普通实现方式
 */
fun bsearch(array: IntArray, size: Int, value: Int): Int {
    var low = 0
    var high = size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            array[mid] == value -> return mid
            array[mid] < value -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return -1
}

/**
 * 二分查找的递归实现
 */
fun bSearchRecursive(array: IntArray, size: Int, value: Int): Int {
    return bSearchInternally(array, 0, size - 1, value)
}

fun bSearchInternally(array: IntArray, low: Int, high: Int, value: Int): Int {
    if (low > high) return -1
    val mid = low + (high - low) / 2
    return when {
        array[mid] == value -> mid
        array[mid] < value -> bSearchInternally(array, mid + 1, high, value)
        else -> bSearchInternally(array, low, mid - 1, value)
    }
}

/**
 * 查找第一个值等于给定值的元素的二分查找
 * 可以解决如果有多个重复元素的情况
 */
fun bSearchFirst(array: IntArray, size: Int, value: Int): Int {
    var low = 0
    var high = size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            array[mid] > value -> high = mid - 1
            array[mid] < value -> low = mid + 1
            // 如果mid - 1位置上array的值不是value或者而是mid为0 那么直接返回mid，否则按照最基本的二分查找继续查找
            else -> if (mid == 0 || array[mid - 1] != value) return mid else high = mid - 1

        }
    }
    return -1
}

/**
 * 查找最后一个值等于给定值的元素的二分查找
 * 可以解决如果有多个重复元素的情况
 */
fun bSearchLast(array: IntArray, size: Int, value: Int): Int {
    var low = 0
    var high = size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            array[mid] > value -> high = mid - 1
            array[mid] < value -> low = mid + 1
            // 如果mid + 1位置上array的值不是value或者而是mid为array内最后一个元素 那么直接返回mid，否则按照最基本的二分查找继续查找
            else -> if (mid == size - 1 || array[mid + 1] != value) return mid else low = mid + 1
        }
    }
    return -1
}

/**
 * 查找第一个值等于大于等于给定值的元素的二分查找
 * 可以解决如果有多个重复元素的情况
 */
fun bSearchFirstLagger(array: IntArray, size: Int, value: Int): Int {
    var low = 0
    var high = size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] >= value) {
            // 如果mid为0或者array的mid -1的位置的值小于value，那么这个时候的mid肯定是第一个大于等于给定值的元素
            if (mid == 0 || array[mid - 1] < value) return mid
            // 否则大于等于的值位于low至mid - 1内
            else high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

/**
 * 查找最后一个值小于等于给定值的元素的二分查找
 * 可以解决如果有多个重复元素的情况
 */
fun bSearchLastLitle(array: IntArray, size: Int, value: Int): Int {
    var low = 0
    var high = size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (array[mid] > value) {
            high = mid - 1
        } else {
            if (mid == size - 1 || array[mid + 1] > value) return mid
            else low = mid + 1
        }
    }
    return -1
}