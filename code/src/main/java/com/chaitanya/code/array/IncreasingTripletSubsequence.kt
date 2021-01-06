package com.chaitanya.code.array

class IncreasingTripletSubsequence {

    fun increasingTriplet(nums: IntArray): Boolean {
        val length = nums.size

        if(length<3) return false
        var num1 = nums[0]
        var num2=nums[1]

        for( i in 0 until length){
            when {
                nums[i]<=num1 -> num1=nums[i]
                nums[i]<=num2 -> num2=nums[i]
                else -> return true
            }
        }
        return false
    }
}