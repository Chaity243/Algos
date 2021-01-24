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

    connect(t1)

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