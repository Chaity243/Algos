package com.chaitanya.code.linkedlist

import com.chaitanya.code.linkedlist.PrintLinkedList.Companion.printLl

fun main() {
    print("\nProgram execution start\n ==============================================\n\n")

    //LinkedList 1
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


    //LinkedList 2
    val l21 = ListNode(1)
    val l22 = ListNode(5)
    val l23 = ListNode(3)
    val l24 = ListNode(6)
    val l25 = ListNode(9)
    val l26 = ListNode(9)
    l21.next = l22
    l22.next = l23
    l23.next = l24
    l24.next = l25
    l25.next = l26

    println("Original LinkedList 1: ")
    PrintLinkedList.printLl(l11)

    println("Original LinkedList 2: ")
    PrintLinkedList.printLl(l21)

    println("Intersection at Node: ")
    print(getIntersectionNode(l11, l21))
    print("\nProgram execution end\n ==============================================")
}

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var intersection :ListNode?=ListNode(5)

    var l1=reversedLL(headA)
    printLl(l1)

    var l2=reversedLL(headB)
    return intersection


}

fun reversedLL(head: ListNode?): ListNode? {
    var tail =head
    var temp =  tail?.next
    var tempNext = temp?.next

    // l1-> l2 -> l3 ->l4 -> null
    //l4->l3->l2-> l1

    while ( tail!=null){
        temp?.next=tail
        tempNext?.next=temp
        tail=tempNext
        temp =  tail?.next
        tempNext = temp?.next
    }
    println("Reversed LL")
    printLl(tail)
    return tail


}
