package com.chaitanya.code.treeandgraphs

fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    val t1 = Node(1)
    val t2 = Node(2)
    val t3 = Node(3)
    val t4 = Node(4)
    val t5 = Node(5)
    val t6 = Node(6)
    val t7 = Node(7)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t3.left = t6
    t3.right = t7

    connect3(t1)

    print("\nProgram execution end\n ==============================================")
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}


class Queue {

    var length: Int = 0
    private var head: Node? = null
    private var tail: Node? = null

    fun push(data: Node) {

        if (head == null) {
            head = data
            tail = head
        } else {
            tail?.next = data
            tail = data
        }

        length++

    }

    fun pop(): Node? {
        val temp = head
        head = this.head?.next
        length--
        return temp
    }

    fun peek() = head

    fun size() = length
}

// Approach 1
fun connect(root: Node?): Node? {
    val q = Queue()
    root?.let { q.push(it) }
    val n = Node(0)
    q.push(n)

    while (q.size() != 0) {
        val currentNode = q.pop()

        println("Current Node Value: ${currentNode?.`val`}")
        if (currentNode?.`val` != 0) {
            if (currentNode?.left != null) {
                q.push(currentNode.left!!)
                if (currentNode.right != null) currentNode.left!!.next = currentNode.right
                else if (q.size() != 0 && q.peek()?.`val` != 0) {
                    val nextNode = q.peek()
                    when {
                        nextNode?.left != null -> currentNode.left!!.next = nextNode.left
                        nextNode?.right != null -> currentNode.left!!.next = nextNode.right
                        else -> currentNode.left!!.next = null
                    }
                } else {
                    currentNode.left!!.next = null
                    q.push(n)
                }
            }

            if (currentNode?.right != null) {
                q.push(currentNode.right!!)
                if (q.size() != 0 && q.peek()?.`val` != 0) {
                    val nextNode = q.peek()
                    when {
                        nextNode?.left != null -> currentNode.right!!.next = nextNode.left
                        nextNode?.right != null -> currentNode.left!!.next = nextNode.right
                        else -> currentNode.left!!.next = null
                    }
                } else {
                    currentNode.right!!.next = null
                    q.push(n)
                }
            }
        }
    }
    return root


}

// Above Approach better solution

fun connect3(root: Node?): Node? {
    val q = ArrayList<Node?>()
    root?.let { q.add(it) }
    q.add(null)

    while (q.isNotEmpty()) {
        val node = q.removeAt(0)
        println("Current Node : ${node?.`val`}")
        if (node != null) {
            if (q.isNotEmpty()) {
                if (node == null) q.add(null)
                node.next = q.elementAt(0)
            }
            if (node.left != null) q.add(node.left)
            if (node.right != null) q.add(node.right)
           // if (q[0] == null) q.add(null)

        }
    }

    return root

}

// Approach2-- Saving the depth along with the Node
fun connect2(root: Node?): Node? {

    //Int to represent the depth of Node
    val q = ArrayList<Pair<Node, Int>>()
    var depth = 0

    if (root != null) q.add(Pair(root, depth)) // Root Node has 0 depth
    else return null

    while (q.isNotEmpty()) {
        val n = q.removeAt(0)
        if (n.first.left != null) {
            q.add(Pair(n.first.left!!, ++depth))
            n.first.left!!.next = when {
                n.first.right != null -> n.first.right
                q.isNotEmpty() && q.elementAt(0).second == n.second && q.elementAt(0).first.left != null -> q.elementAt(0).first.left
                q.isNotEmpty() && q.elementAt(0).second == n.second && q.elementAt(0).first.right != null -> q.elementAt(0).first.right
                else -> null
            }
        }

        if (n.first.right != null) {
            q.add(Pair(n.first.right!!, depth))
            n.first.right!!.next = when {
                q.isNotEmpty() && q.elementAt(0).second == n.second && q.elementAt(0).first.left != null -> q.elementAt(0).first.left
                q.isNotEmpty() && q.elementAt(0).second == n.second && q.elementAt(0).first.right != null -> q.elementAt(0).first.right
                else -> null
            }
        }
    }

    return root
}

