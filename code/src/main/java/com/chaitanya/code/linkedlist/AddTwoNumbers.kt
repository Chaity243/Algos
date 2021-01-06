package com.chaitanya.code.linkedlist

import com.chaitanya.code.linkedlist.PrintLinkedList.Companion.printLl


fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    //First LinkedList
    val l1 = ListNode(2)
    val l12 = ListNode(4)
    val l13 = ListNode(3)
    val l14 = ListNode(6)
    val l15 = ListNode(9)
    val l16 = ListNode(9)
    l1.next = l12
    l12.next = l13
    l13.next = l14
    l14.next = l15
    l15.next = l16

    //Second LinkedList
    val l21 = ListNode(5)
    val l22 = ListNode(6)
    val l23 = ListNode(4)
    val l24 = ListNode(8)
    l21.next = l22
    l22.next = l23
    l23.next = l24

    println("Added Numbers Result: ")
    val result = addTwoNumbers(l1, l21)
    printLl(result)
    print("\nProgram execution end\n ==============================================")

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l: ListNode? = null

    var ll1 = l1
    var ll2 = l2

    printLl(l1)
    printLl(l2)

    var tail: ListNode? = null
    var isCarry = false

    while (ll1 != null || ll2 != null) {
        val num1 =  ll1?.`val`?:0
        val num2=  ll2?.`val`?:0
        var sum = num1+num2
        if (isCarry) {
            sum++
            isCarry = false
        }
        if (sum > 9) {
            isCarry = true
            sum = extractUnitPlace(sum)
        }
        val node = ListNode(sum)
        if (l == null) l = node
        if (tail == null) tail = l
        else {
            tail.next = node
            tail = node
        }

        ll1 = ll1.let { it?.next }
        ll2 = ll2.let { it?.next }

    }

    if (isCarry) {
        val node  =  ListNode(1)
        tail?.next = node
    }
    return l
}
private fun extractUnitPlace(localDigitSum: Int) = localDigitSum % 10



