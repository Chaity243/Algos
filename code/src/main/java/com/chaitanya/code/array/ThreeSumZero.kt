package com.chaitanya.code.array

class ThreeSumZero {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val length = nums.size

        // return empty if doesn't contains 3 elements
        if (length < 3) return mutableListOf<List<Int>>()
        nums.sort()

        val results = mutableListOf<List<Int>>()
        val stringList = mutableListOf<String>()

        // Create a HashMap to speed up search
        val numsMap = HashMap<Int, Int>()
        var l = 0

        // fill values in hashmap
        nums.forEach {
            numsMap[l++] = it
        }

        //Print the values filled hashmap
        // numsMap.forEach { (key, value) -> println(" Key : $key, Value: $value") }

        for (i in 0 until length) {
            for (j in i + 1 until length) {
                var number = -(nums[i] + nums[j])
                if (nums[i] + nums[j] == 0) number = 0

                println("Check for pair ${nums[i]}, ${nums[j]} should be $number")

                val noOfKeys = numsMap.filterValues { it == number }.keys
                println("noOfKeys for  $number is ${noOfKeys.size}")

                if (numsMap.containsValue(number) && (nums[j] < number || (nums[j] == number && noOfKeys.size > 1 && number != 0) || (nums[j] == 0 && noOfKeys.size > 2))) {


                    // println("Match for pair ${nums[i]}, ${nums[j]} :-> $number with Key: $k")
                    val result = listOf(nums[i], nums[j], number)
                    val stringResult = nums[i].toString() + nums[j].toString() + number.toString()
                    if (!stringList.contains(stringResult)) {
                        results.add(result)
                        stringList.add(stringResult)
                    }
                    // println("Result for pair ${nums[i]}, ${nums[j]} is $number ")

//                    break
                }
            }
        }

        return results

    }


}