package com.chaitanya.code.array

class Test {

    class Solution {
        fun threeSum(nums: IntArray): List<List<Int>> {
            val length = nums.size

            // return empty if doesn't contains 3 elements
            if (length < 3) return mutableListOf<List<Int>>()
            nums.sort()

            val triplets = mutableListOf<List<Int>>()

            for (i in 0 until length - 1) {
                var j = i + 1
                var k = length - 1

                while (j < k) {
                    val req = 0 - (nums[i] + nums[j])

                    when {
                        req < nums[k] -> {
                            k--
                        }
                        req == nums[k] -> {
                            println("Triplet at $i, $j, $k: ${nums[i]}, ${nums[j]}, ${nums[k]}")
                            j++
                            k--
                            val triplet = listOf(nums[i], nums[j], nums[k])
                            triplets.add(triplet)
                        }
                        else -> {
                            j++
                        }
                    }

                }
            }
            return triplets
        }

    }

}