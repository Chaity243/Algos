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
    l21.next = l22
    l22.next = l13

    println("Original LinkedList 1: ")
    printLl(l11)

    println("Original LinkedList 2: ")
    printLl(l21)

    println("Intersection at Node: ")
    print(getIntersectionNode(l11, l21)?.`val`)
    print("\nProgram execution end\n ==============================================")
}

/*First we will calculate the difference and traverse the longer LinkedList to the node from where both the linkedlist  have same length remaining to be traversed and can be traversed together*/
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var l1=headA
    var l2=headB

    val countA = getCount(headA)
    println("HeadA Count $countA")

    val countB = getCount(headB)
    println("HeadB Count $countB")

    var diff:Int

    if(countA>countB) {
        diff = countA-countB

        while (diff!=0){
            diff--
            l1=l1?.next
        }
    }
    else if(countB > countA){
        diff = countB-countA
        while (diff!=0){
            diff--
            l2=l2?.next
        }
    }

    var result: ListNode? = null
    var isResult = false

    while (l1 != null && l2 != null) {


        if (l1 == l2){
            if(!isResult){
                result = l1
                isResult=true
            }
        }
        else if (isResult){
            result= null
            isResult=false
        }

        l1 = l1.next
        l2 = l2.next

    }

    return result

}

fun getCount(head :ListNode?):Int{
    var count =1
    var h = head
    while(h?.next!=null){
        count++
        h = h.next
    }
    return count
}