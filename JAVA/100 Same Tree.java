/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {p, q});

        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode[] nodes = queue.poll();
                TreeNode p_node = nodes[0];
                TreeNode q_node = nodes[1];
                
                if (p_node.val != q_node.val) {
                    return false;
                }

                if (p_node.left != null && q_node.left != null) {
                    queue.offer(new TreeNode[] {p_node.left, q_node.left});
                }
                else if ((p_node.left != null && q_node.left == null) || (p_node.left == null && q_node.left != null)) {
                    return false;
                }
                if (p_node.right != null && q_node.right != null) {
                    queue.offer(new TreeNode[] {p_node.right, q_node.right});
                }
                else if ((p_node.right != null && q_node.right == null) || (p_node.right == null && q_node.right != null)) {
                    return false;
                }
            }
        }

        return true;
    }
}