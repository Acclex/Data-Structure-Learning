// 冒泡排序
fun bubbleSort(array: Array<Int>, size: Int) {
    if (size < 1) return
    for (i in 0 until size) {
        // 提前退出冒泡的标识
        var flag = false
        for (j in 0 until size - i - 1) {
            if (array[j] > array[j + 1]) {
                val tmp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = tmp
                flag = true // 数据交换
            }
        }
        if (!flag) break // 没有数据交换 退出冒泡
    }
}

// 插入排序
fun insertSort(array: Array<Int>, size: Int) {
    if (size <= 1) return
    for (i in 0 until size) {
        val value = array[i]
        var j = i - 1
        // 查找要插入的位置并移动数据
        while (j >= 0) {
            if (array[j] > value) {
                array[j + 1] = array[j]
            } else {
                break
            }
            j--
        }
        array[j + 1] = value
    }
}