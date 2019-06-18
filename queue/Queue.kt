class ArrayQueue(capacity: Int) {
    // 数组array 数组大小 n
    private val array: Array<String?> = arrayOfNulls(capacity)
    private var n = 0

    // head 表示队列头下标，tail表示队列尾下标
    private var head: Int = 0
    private var tail: Int = 0

    init {
        this.n = capacity
    }

    // 入队
    fun enqueue(item: String): Boolean {
        // 如果队尾到数组长度，则触发数据搬运
        if (tail == n) {
            // 如果head位于0 则说明数据空间已满
            if (head == 0) return false
            // 数据搬移
            for (i in head until tail) {
                array[i - head] = array[i]
            }
            tail -= head
            head = 0
        }
        array[tail] = item
        tail++
        return true
    }

    // 出队
    fun dequeue(): String? {
        if (head == tail) return null
        val ret = array[head]
        head++
        return ret
    }

    fun printAll() {
        for (item in array) {
            println("item =  $item")
        }
    }
}

class LinkedQueue {
    // 链表队列 head队列头部 tail队列尾部
    private var head: Node? = null
    private var tail: Node? = null

    // 入队
    fun enquene(value: Int) {
        val newNode = Node(value, null)
        if (tail != null) {
            tail?.next = newNode
        } else {
            head = newNode
            tail = newNode
        }
    }

    // 出队
    fun dequeue(): Int? {
        if (head == null) return null
        val ret = head?.data
        head = head?.next
        if (head == null) {
            tail = null
        }
        return ret
    }

    // 打印队列全部数据
    fun printAll() {
        val p = head
        while (p != null) {
            println("p.data = ${p.data}")
        }
    }
}

class circleQueue(capacity: Int) {
    // 数组array 数组大小 n
    private val array: Array<String?> = arrayOfNulls(capacity)
    private var n = 0

    // head 表示队列头下标，tail表示队列尾下标
    private var head: Int = 0
    private var tail: Int = 0

    init {
        this.n = capacity
    }

    fun enquene(value: String): Boolean {
        if ((tail + 1) % n == head) return false
        array[tail] = value
        tail = (tail + 1) % n
        return true
    }

    // 出队
    fun dequeue(): String? {
        // 如果head == tail 表示队列为空
        if (head == tail) return null
        val ret = array[head]
        head = (head + 1) % n
        return ret
    }

    fun printAll() {
        if (0 == n) return
        for (item in array) {
            println("item value =$item")
        }
    }
}