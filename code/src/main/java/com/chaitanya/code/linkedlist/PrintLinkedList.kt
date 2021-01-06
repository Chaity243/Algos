package com.chaitanya.code.linkedlist

class PrintLinkedList {

   companion object {
        fun printLl(result: ListNode?) {
            var result1 = result
            print(" LinkedList: ")
            while (result1?.next != null) {
                print("${result1.`val`}, ")
                result1 = result1.next
            }
            print("${result1?.`val`}\n")
        }
    }
}