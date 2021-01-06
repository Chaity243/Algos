package com.chaitanya.code.array

/*Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

class SetMatrixZero {

    // With O(n) space complexity
    fun setZeroesSol1(matrix: Array<IntArray>): Unit {

        val columns = mutableListOf<Int>()

        for (row in matrix) {
            var isZero = false
            for (index in row.indices) {

                if (row[index] == 0) {
                    columns.add(index)
                    isZero = true
                }
            }
            if (isZero) for (i in row.indices) row[i] = 0

        }

        columns.distinct()

        for (k in matrix.indices) for (j in columns) matrix[k][j] = 0

    }

    // With constant  space complexity
    fun setZeroesSol2(matrix: Array<IntArray>): Unit {


        var isRow = false
        var isCol = false

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    //set first row and column as 0 to indicate which row and col should be entirely zero
                    matrix[i][0] = 0
                    matrix[0][j] = 0

                    //matrix[0][0] ==0 can be because of row or col  value so we are using two flags to store this information
                    if (i == 0 && j == 0) {
                        isRow = true
                        isCol = true
                    } else if (i == 0) {
                        isCol = true
                        println("$i,$j: ${matrix[i][j]} isRow: ${isCol}")
                    } else if (j == 0) {
                        isRow = true
                        println("$i,$j: ${matrix[i][j]} isRow: ${isRow}")
                    }
                }
            }
        }


        for (i in matrix.indices) {
            if (matrix[i][0] == 0) {
                // skip 0th else it will set all cell values to zero, will handle it separate based on flag value
                if (i == 0) continue
                for (k in matrix[i].indices) {

                    matrix[i][k] = 0
                }
            }
        }

        for (i in matrix[0].indices) {
            if (matrix[0][i] == 0) {
                // skip 0th else it will set all cell values to zero, will handle it separate based on flag value
                if (i == 0) continue
                for (j in matrix.indices) {
                    matrix[j][i] = 0
                }

            }
        } // Lets handle now matrix[0][0]==0 case
        if (isCol) for (k in matrix[0].indices) matrix[0][k] = 0
        if (isRow) for (k in matrix.indices) matrix[k][0] = 0
    }
}