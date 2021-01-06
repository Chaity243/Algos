package com.chaitanya.code

class Node(val value: Any) {
    var next: Node? = null
}

class Stack(private var top: Node? = null, private var bottom: Node? = null, private var length: Int = 0) {

    //Peek
    fun peek() {
        //empty

    }

    //Push
    fun push(value: Any) {

        if (length == 0) {
            top = Node(value)
            bottom = top
        } else {
            val node = Node(value)
            bottom?.next = node
            bottom = node
        }

        length++
        println("Length :$length and Pushed Node ${bottom?.value}")

    }


    //Pop
    fun pop(): Node? {
        return if (length == 0) {
            println("Empty Stack...noting to return ")
            null
        } else {
            var node = top
            while (node?.next?.next != null) {
                node = node.next
            }
            val temp = bottom
            bottom = node
            length--
            print("Length :$length and Popped Node ${temp?.value}")
            temp

        }
    }
}

