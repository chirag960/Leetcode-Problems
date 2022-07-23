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
    public int maxDepth(TreeNode root) {
        int ans = recur(root, 0);
        return ans;
    }
    
    public static int recur(TreeNode node, int currDepth){
        if(node == null){
            return currDepth;
        }
        
        int left = recur(node.left, currDepth+1);
        int right = recur(node.right, currDepth+1);
        
        return Math.max(left, right);        
    }
}