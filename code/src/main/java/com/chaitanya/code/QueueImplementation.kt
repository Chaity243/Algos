package com.chaitanya.code

private class Node<T>(val data: T) {
    var next: Node<T>? = null
}



class Queue<T> {

    var length: Int = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(data: T) {
        val n = Node(data)
        if (head == null) {
            head = n
            tail = head
        } else {
            tail?.next = n
            tail = n
        }

        length++

    }

    fun pop(): T? {
        val temp = head?.data
        head = this.head?.next
        length--
        return temp
    }

    fun peek()= head?.data

    fun size() = length
}