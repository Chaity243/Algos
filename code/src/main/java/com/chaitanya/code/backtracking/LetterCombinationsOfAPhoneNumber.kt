package com.chaitanya.code.backtracking


fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

    println(letterCombinationsRecursive(""))

    print("\nProgram execution end\n ==============================================")

}

//Recursive Solution
fun letterCombinationsRecursive(digits: String): List<String> {
    val resultList = mutableListOf<String>()
    if (digits.isBlank()) return resultList
    val charNoArray = arrayOf("null", "null", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    backTrack(digits, 0, charNoArray, resultList, StringBuilder())
    return resultList

}

fun backTrack(digits: String, i: Int, charNoArray: Array<String>, resultList: MutableList<String>, stringBuilder: StringBuilder) {
    if (i == digits.length) {
        resultList.add(stringBuilder.toString())
        return
    }

    val index = digits[i].toInt() - 48
    val noChars = charNoArray[index]

    for (c in noChars.toCharArray()) {
        stringBuilder.append(c)
        backTrack(digits, i + 1, charNoArray, resultList, stringBuilder)
        stringBuilder.delete(stringBuilder.length - 1, stringBuilder.length)
    }
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
    charsNoHash['8'] = listOf("t", "u", "v")
    charsNoHash['9'] = listOf("w", "x", "y", "z")

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