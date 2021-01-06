package com.chaitanya.code.linkedlist

import com.chaitanya.code.linkedlist.PrintLinkedList.Companion.printLl

fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    //LinkedList
    val l11 = ListNode(2)
    val l12 = ListNode(4)
    val l13 = ListNode(3)
    val l14 = ListNode(6)
    val l15 = ListNode(9)
    val l16 = ListNode(9)
    l11.next = l12
    l12.next = l13
    l13.next = l14
    l14.next = l15
    l15.next = l16

    println("Original LinkedList: ")
    printLl(l11)

    println("Even + Odd LinkedList: ")
    printLl(oddEvenList(l11))
    print("\nProgram execution end\n ==============================================")
}

fun oddEvenList(head: ListNode?): ListNode? {
    var originalHead = head
    var newHead: ListNode? = null
    var newTail: ListNode? = null
    var temp :ListNode?=null
    while (originalHead != null) {
        if (newHead == null) newHead = originalHead.next
        if (newTail == null) newTail = originalHead.next
        else {
            newTail.next = originalHead.next
            newTail = originalHead.next
        }

        originalHead.next = originalHead.next?.next
        temp= originalHead
        originalHead = originalHead.next

    }
    temp?.next = newHead
    return head

}