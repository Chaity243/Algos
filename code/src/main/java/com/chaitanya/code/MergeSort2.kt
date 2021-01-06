package com.chaitanya.code

class MergeSort2 {

    fun mergeSortCode(arr: IntArray): IntArray {

        val length = arr.size
        val mid = length / 2
        val arr1 = arr.slice(0 until mid).toIntArray()
        val arr2 = arr.slice(mid until length).toList().toIntArray()

        return mergeTheDividedArray(mergeSortCode(arr1),mergeSortCode(arr2) )
    }

    private fun mergeTheDividedArray(arr1: IntArray, arr2: IntArray): IntArray {
        val sizeOfMergeArray = (arr1.size + arr2.size)
        println("Size of Merged Array : ${sizeOfMergeArray}")
        val mergedArray: IntArray = intArrayOf(sizeOfMergeArray)

        var index1 = 0
        var index2 = 0
        var index = 0

        while (index1 < arr1.size || index2 < arr2.size) {
            if (index1 >= arr1.size || index2 >= arr2.size) {
                if (index1 > index2) {
                    mergedArray[index] = arr2[index2]
                    index2++
                } else {
                    mergedArray[index] = arr1[index1]
                    index1++

                }
            }
            else if (arr1[index1] > arr2[index2]) {
                mergedArray[index] = arr2[index2]
                index2++

            }
            else {
                mergedArray[index] = arr1[index1]
                index1++
            }
            index++
        }

        return mergedArray
    }
}