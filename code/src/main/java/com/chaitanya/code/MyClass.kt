package com.chaitanya.code

import com.chaitanya.code.array.ThreeSumZero

fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    callProgram()

    print("\nProgram execution end\n ==============================================")

}

fun callProgram() {
    /*String Reversal Program*/
//    val str = "My name is Chaitanya"
//    ReverseString().reverseString(str)


    /*Slack implementation and push, pop, seek operatoins*/
//    stackImplementation()

/*Merge Sorting */

//    mergeSorting()

    /*Triplets with sum 0*/

     tripletSumZero()

}

fun tripletSumZero() {

    println("Required triplets \n\n\n")
    ThreeSumZero().threeSum(intArrayOf(-2, 0, 1, 1, 2)).forEach{

        println( it.toString())

    }}

fun stackImplementation(){
    val mySlack  = Stack()
    mySlack.push( "discord")
    mySlack.push( "udemy")
    mySlack.push( "google")
    mySlack.pop()
    mySlack.pop()
    mySlack.pop()
    mySlack.pop()
    mySlack.pop()
}

fun mergeSorting(){
    val list= listOf(32,56,1,67,34,65,33,22,4,5,8,9)
    println("Original unsorted list $list\n\n")
    println("Sorted list after merge sort application : \n ${MergeSort().mergeSort(list)}")

    /*   merged Sort for IntArray*/

//    val arrayOfIntegers= intArrayOf(32,56,1,67,34,65,33,22,4,5,8,9)
//    println("Original unsorted list $arrayOfIntegers\n\n")
//    println("Sorted list after merge sort application : \n ${MergeSort2().mergeSortCode(arrayOfIntegers)}")
//
//
}
