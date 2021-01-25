package com.chaitanya.code.treeandgraphs

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

    println(BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(t1))

    print("\nProgram execution end\n ==============================================")

}

class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val rowCount = grid.size
        val colCount = grid[0].size
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    count++
                    dfs(rowCount, colCount, grid, i, j)

                }
            }

        }
        return count
    }

    private fun dfs(rowCount: Int, colCount: Int, grid: Array<CharArray>, i: Int, j: Int) {
        //Mark current cell as visited
        grid[i][j] = '2'

        //Check adjacent nodes whether they are the part of same island or not.
        if (i - 1 >= 0 && grid[i - 1][j] == '1') dfs(rowCount, colCount, grid, i - 1, j)
        if (j - 1 >= 0 && grid[i][j - 1] == '1') dfs(rowCount, colCount, grid, i, j - 1)
        if (i + 1 < rowCount && grid[i + 1][j] == '1') dfs(rowCount, colCount, grid, i + 1, j)
        if (j + 1 < colCount  && grid[i][j + 1] == '1') dfs(rowCount, colCount, grid, i, j + 1)
    }
}
