package com.chaitanya.code

class MergeSort {

    fun mergeSort(list: List<Int>): List<Int> {
        println( "List Rcvd: $list" )
        val length = list.size
        if (length < 2) return list
        val mid: Int = length / 2
        val arr1 = list.slice(0 until mid)
        val arr2 = list.slice(mid until length)

        return mergeEachResult(mergeSort(arr1), mergeSort(arr2))
    }

    private fun mergeEachResult(arr1: List<Int>, arr2: List<Int>): List<Int> {
        println("Arr1 : ${arr1.joinToString()} and Arr2 : ${arr2.joinToString()} ")
        val mergedArray: MutableList<Int> = mutableListOf()
        var i1 = 0
        var i2 = 0

        while (i1 < arr1.size || i2 < arr2.size) {
            if (i1 >= arr1.size || i2 >= arr2.size) {
                if (i2 > i1) {
                    mergedArray.add(arr1[i1])
                    i1++
                } else {
                    mergedArray.add(arr2[i2])
                    i2++

                }
            } else if (arr1[i1] < arr2[i2]) {
                mergedArray.add(arr1[i1])
                i1++

            } else {
                mergedArray.add(arr2[i2])
                i2++
            }

        }

        println("Merged Sorted List Returned  $mergedArray")
        return mergedArray
    }
}