package com.chaitanya.code.array

class LongestSubstring {

    fun lengthOfLongestSubstring(s: String): Int {
        var count = 0
        var startIndex = 0
        var prevCount = 0
        val hashString = HashMap<Int, Any>()

        for (i in s.indices) {
            if (hashString.containsValue(s[i])) {
                val repeatedIndex = hashString.filterValues { it == s[i] }.keys.elementAt(0)
                for (k in startIndex..repeatedIndex) hashString.remove(k)
                startIndex=repeatedIndex+1
                if (prevCount < count) prevCount = count
                count = hashString.size
            }
            hashString[i] = s[i]
            count++
        }

        if (prevCount < count) prevCount = count
        return prevCount
    }
}