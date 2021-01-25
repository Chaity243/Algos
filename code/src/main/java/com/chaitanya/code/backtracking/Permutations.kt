package com.chaitanya.code.backtracking

fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    val input = intArrayOf(1, 2, 3, 4)

    println(permuteRecursive(input))

    print("\nProgram execution end\n ==============================================")

}

fun permuteRecursive(nums: IntArray): List<List<Int>> {
    val resultList = mutableListOf<List<Int>>()
    if (nums.isEmpty()) return resultList
    calComb(nums, resultList, mutableListOf())

    return resultList.toList()
}

fun calComb(nums: IntArray,resultList: MutableList<List<Int>> , elemList: MutableList<Int>) {
    if (nums.isEmpty()) {
        println("Possible Permutation $elemList")
        resultList.add(elemList.toList())
        return
    }

    for (j in nums) {
        elemList.add(j)
        val numsList = nums.toMutableList()
        numsList.remove(j)
        val newNums = numsList.toIntArray()

        calComb(newNums, resultList, elemList)
        elemList.remove(j)
    }
}
