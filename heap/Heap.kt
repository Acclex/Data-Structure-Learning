package heap

class Heap(private val size: Int) {
    private val array = IntArray(size + 1)
    private var count = 0

    // 堆的插入
    fun insert(value: Int) {
        if (count >= size) return
        count++
        array[count] = value
        var i = count
        while (i / 2 > 0 && array[i] > array[i / 2]) {
            swap(array, i, i / 2)
            i /= 2
        }
    }

    // 堆删除堆顶的数据
    fun deleteHead() {
        if (count == 0) return
        array[1] = array[count]
        count--
        reset(1)
    }

    // 删除后将堆进行堆化，依然保证堆的特性
    private fun reset(i: Int) {
        var pos = i
        while (true) {
            var max = pos
            if (pos * 2 <= size && array[pos] < array[pos * 2]) max = pos * 2
            if (pos * 2 + 1 <= size && array[max] < array[pos * 2 + 1]) max = pos * 2 + 1
            if (max == 1) break
            swap(array, pos, max)
            pos = max
        }
    }
}

/**
 * 构建堆
 */
private fun buildHeap(a: IntArray, n: Int) {
    for (i in n / 2 downTo 1) {
        heapify(a, n, i)
    }
}

/**
 * 从上往下，也就是数组从后往前进行对堆化
 */
private fun heapify(array: IntArray, size: Int, i: Int) {
    var i = i
    while (true) {
        var maxPos = i
        if (i * 2 <= size && array[i] < array[i * 2]) maxPos = i * 2
        if (i * 2 + 1 <= size && array[maxPos] < array[i * 2 + 1]) maxPos = i * 2 + 1
        if (maxPos == i) break
        swap(array, i, maxPos)
        i = maxPos
    }
}

/**
 * 堆排序
 */
fun sort(array: IntArray, size: Int) {
    buildHeap(array, size)
    var k = size
    while (k > 1) {
        swap(array, 1, k)
        k--
        heapify(array, k, 1)
    }
}

/**
 * 交换数组中的位置
 */
private fun swap(array: IntArray, first: Int, second: Int) {
    val tmp1 = array[first]
    val tmp2 = array[second]
    array[first] = tmp2
    array[second] = tmp1
}



