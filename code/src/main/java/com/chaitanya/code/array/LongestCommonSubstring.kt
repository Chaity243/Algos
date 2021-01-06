package com.chaitanya.code.array

fun main(args: Array<String>) {
    print("\nProgram execution start\n ==============================================\n\n")

   println("Longest Palindrome: ${longestPalindromeSol1("bb")}")

    print("\nProgram execution end\n ==============================================")

}

/*Solution 1 with O(n^2) Time complexity*/
private fun longestPalindromeSol1(s: String): String {
    if(s.length<=1) return s

    var palString=""
    var palLength = 0

    for( i in 0 .. s.length-2){
        for( j in i until s.length){
            val str= s.substring(i, j+1)
            if(isPal(str) && palLength<str.length){
                palString=str
                palLength=str.length
            }
        }
    }
    return palString
}

private fun isPal(s:String) : Boolean{
    var l = s.length-1
    var i = 0

    while (i<=l){
        if(s[i]==s[l]){
            i++
            l--
        }
        else return false
    }
    return true
}