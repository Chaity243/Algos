package com.chaitanya.code.treeandgraphs

fun main() {
    print("\n==============Program execution starts==============================================\n\n")

    /*Tree data structure creation*/
    val t1= TreeNode(3)
    val t2= TreeNode(9)
    val t3= TreeNode(20)
    val t4= TreeNode(15)
    val t5= TreeNode(7)
    t1.left=t2
    t1.right=t3
    t3.left=t4
    t3.right=t5
    traversal(t1)
    println("Tree Inorder Traversal:  $inOrder}")

    print("\n================Program execution ends==============================================")

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

val inOrder: MutableList<Int> = mutableListOf()

fun traversal(root: TreeNode?){
    if (root==null) return
    traversal(root.left)
    root.let { inOrder.add(it.`val`) }
    traversal(root.right)
}
