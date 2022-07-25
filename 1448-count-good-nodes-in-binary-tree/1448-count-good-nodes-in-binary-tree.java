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
    
    int goodNodesCount = 0;
    
    public int goodNodes(TreeNode root) {
        
        recur(root, root.val);
        return goodNodesCount;
    }
    
    public void recur(TreeNode node, int max){
        if(node == null){
            return;
        }
        if(node.val >= max){
            goodNodesCount++;
            max = node.val;            
        }
        recur(node.left, max);
        recur(node.right, max);        
    }
}