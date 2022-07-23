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
    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }
    
    public void recur(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right==null){
            return;
        }
        if(node.right == null){
            node.right = node.left;
            node.left = null;
            recur(node.right);
        }
        else if(node.left == null){
            node.left = node.right;
            node.right = null;
            recur(node.left);
        }
        else{
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            recur(node.left);
            recur(node.right);
        }
        
    }
}