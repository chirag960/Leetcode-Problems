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
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    
    public int maxSum(TreeNode node){
        if(node == null){
            return 0;
        }else{
            int left = maxSum(node.left);
            int right = maxSum(node.right);
            
            left = Math.max(left, 0);
            right = Math.max(right, 0);
            
            max = Math.max(max, left + right + node.val);
            
            return node.val + Math.max(left, right);
        }
    }
}