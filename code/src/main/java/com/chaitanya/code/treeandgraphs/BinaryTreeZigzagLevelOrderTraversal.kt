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

class BinaryTreeZigzagLevelOrderTraversal {
    private fun <T> MutableList<T>.push(item: T) = this.add(this.count(), item)
    private fun <T> MutableList<T>.pop(): T? = if (this.count() > 0) this.removeAt(this.count() - 1) else null

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val zzList = mutableListOf<MutableList<Int>>()
        val leftStack: Stack = mutableListOf()
        val rightStack: Stack = mutableListOf()

        if (root != null) zzList.add(mutableListOf(root.`val`))
        else return emptyList()

        rightStack.push(root)
        while (leftStack.isNotEmpty() || rightStack.isNotEmpty()) {

            val lList = mutableListOf<Int>()
            while (leftStack.isNotEmpty()) {
                val temp = leftStack.pop()

                if (temp?.left != null) {
                    rightStack.push(temp.left!!)
                    lList.add(temp.left!!.`val`)
                }
                if (temp?.right != null) {
                    rightStack.push(temp.right!!)
                    lList.add(temp.right!!.`val`)
                }
                if (leftStack.isEmpty() && rightStack.isNotEmpty()) zzList.add(lList)
            }


            val rList = mutableListOf<Int>()
            while (rightStack.isNotEmpty()) {
                val temp = rightStack.pop()

                if (temp?.right != null) {
                    leftStack.push(temp.right!!)
                    rList.add(temp.right!!.`val`)
                }
                if (temp?.left != null) {
                    leftStack.push(temp.left!!)
                    rList.add(temp.left!!.`val`)
                }

                if (rightStack.isEmpty() && leftStack.isNotEmpty()) zzList.add(rList)
            }


        }
        return zzList


    }
}

typealias Stack = MutableList<TreeNode?>