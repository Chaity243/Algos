package com.chaitanya.code.backtracking

import com.chaitanya.code.treeandgraphs.TreeNode


fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    val t1 = TreeNode(3)
    val t2 = TreeNode(9)
    val t3 = TreeNode(20)
    val t4 = TreeNode(15)
    val t5 = TreeNode(7)
    t1.left = t2
    t1.right = t3
    t3.left = t4
    t3.right = t5

    println(letterCombinations("234"))

    print("\nProgram execution end\n ==============================================")

}

fun letterCombinations(digits: String): List<String> {
    val resultList = mutableListOf<String>()
    var mutDigits = digits
    val charsNoHash = HashMap<Char, List<String>>()

    charsNoHash['2'] = listOf("a", "b", "c")
    charsNoHash['3'] = listOf("d", "e", "f")
    charsNoHash['4'] = listOf("g", "h", "i")
    charsNoHash['5'] = listOf("j", "k", "l")
    charsNoHash['6'] = listOf("m", "n", "o")
    charsNoHash['7'] = listOf("p", "q", "r", "s")
    charsNoHash['8'] = listOf( "t", "u", "v")
    charsNoHash['9'] = listOf( "w", "x", "y", "z")

    while (mutDigits.isNotEmpty()) {
        val char = mutDigits[0]
        mutDigits = mutDigits.removePrefix(char.toString())

        val charList = charsNoHash[char]
        if (resultList.isEmpty()) charList?.let { resultList.addAll(it) }
        else {
            val tempList = mutableListOf<String>()
            for (i in resultList) for (j in charList!!) tempList.add(i + j)
            resultList.clear()
            resultList.addAll(tempList)
        }
    }
    return resultList
}