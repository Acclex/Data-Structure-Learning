package tree

class BinarySerachTree {
    private var tree: Node? = null
    private val list = mutableListOf<Int>()

    fun find(value: Int): Node? {
        var p = tree
        while (p != null) {
            p = when {
                value < p.data -> p.left
                value > p.data -> p.right
                else -> return p
            }
        }
        return null
    }

    fun inseret(value: Int) {
        if (tree == null) {
            tree = Node(value, null, null)
            return
        }

        var p = tree
        while (p != null) {
            if (value <= p.data) {
                if (p.left == null) {
                    p.left = Node(value, null, null)
                    return
                }
                p = p.left
            } else { // value > p.data
                if (p.right == null) {
                    p.right = Node(value, null, null)
                    return
                }
                p = p.right
            }
        }
    }

    fun delete(value: Int) {
        var p = tree
        var pp: Node? = null
        while (p != null && p.data != value) {
            pp = p
            p = if (value > p.data) p.right
            else p.left
        }

        if (p == null) return

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            var min = p.right
            var minP = p
            while (min!!.left != null) {
                minP = min
                min = min.left
            }
            p.data = min.data // 将数据搬移
            p = min
            pp = minP
        }

        // 要删除的节点只有一个子节点或者没有子节点
        var child: Node? = null
        when {
            p.left != null -> child = p.left
            p.right != null -> child = p.right
            else -> child = null
        }
        when {
            pp == null -> tree = child //删除的是根节点
            pp.left == p -> pp.left = child
            else -> pp.right = child
        }
    }

    fun getMax(): Node? {
        var p = tree
        return if (p == null) null
        else {
            while (p!!.right != null) {
                p = p.right
            }
            p
        }
    }

    fun getMin(): Node? {
        var p = tree
        return if (p == null) null
        else {
            while (p!!.left != null) {
                p = p.left
            }
            return p
        }
    }

    // 中序遍历二叉树，返回一个有序的数组
    fun inOrder(): List<Int> {
        val p = tree
        list.clear()
        return if (p == null) list
        else {
            inOrder(p)
            list
        }
    }

    private fun inOrder(root: Node?) {
        if (root == null) return
        inOrder(root.left)
        list.add(root.data)
        inOrder(root.right)
    }
}

class Node(var data: Int, var left: Node?, var right: Node?)