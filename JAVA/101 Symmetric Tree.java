/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
 

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
    public boolean isSymmetric(TreeNode root) {
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        else if (root.left == null && root.right == null) {
            return true;
        }

        TreeNode lt = root.left;
        TreeNode rt = root.right;

        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[] {lt, rt});

        while (!q.isEmpty()) {
            TreeNode[] nodes = q.poll();
            TreeNode ln = nodes[0];
            TreeNode rn = nodes[1];

            if (ln.val != rn.val) {
                return false;
            }

            if (ln.left != null && rn.right != null) {
                q.offer(new TreeNode[] {ln.left, rn.right});
            }
            else if ((ln.left != null && rn.right == null) || (ln.left == null && rn.right != null)) {
                return false;
            }
            if (ln.right != null && rn.left != null) {
                q.offer(new TreeNode[] {ln.right, rn.left});
            }
            else if ((ln.right != null && rn.left == null) || (ln.right == null && rn.left != null)) {
                return false;
            }
        }
        return true;
    }
}