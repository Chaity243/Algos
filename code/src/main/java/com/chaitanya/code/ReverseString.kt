package com.chaitanya.code

class ReverseString {

    fun reverseString(str: String) {
        print ("\nOriginal String : $str\n")

        var reversedString:String?=""

        for (i in str.length - 1 downTo 0) {
            reversedString+=str[i]
        }

        print("\n Reversed String:= $reversedString")
    }
}