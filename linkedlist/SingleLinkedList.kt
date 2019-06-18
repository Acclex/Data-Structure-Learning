class SingleLinkedList {
    // 单链表反转
    fun reverse(list: Node): Node? {
        var cur = list
        var preReturn: Node? = null
        while (cur.next != null) {
            val node = cur.next
            cur.next = preReturn
            preReturn = cur
            cur = node!!
        }
        return preReturn
    }

    // 检测环
    fun checkCircle(list: Node?): Boolean {
        if (list == null) return false
        var slow = list
        var fast = list.next
        while (fast?.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
            if (fast == slow) return true
        }
        return false
    }

    // 合并两个有序单链表
    fun mergeLinkedList(la: Node, lb: Node): Node {
        var p = la
        var q = lb
        val head: Node
        if (p.data < q.data) {
            head = p
            p = p.next!!
        } else {
            head = q
            q = q.next!!
        }
        var node = head
        while (p.next != null && q.next != null) {
            if (p.data < q.data) {
                node.next = p
                p = p.next!!
            } else {
                node.next = q
                q = q.next!!
            }
            node = node.next!!
        }
        return head
    }

    fun deleteLastKth(list: Node, k: Int) {

    }

    // 求中间结点
    fun findMiddleNode(list: Node?): Node? {
        if (list == null) return null

        var fast = list
        var slow = list

        while (fast!!.next != null && fast.next!!.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }

        return slow
    }
}

class Node(val data: Int, var next: Node?)