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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            root = node;
            return root;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(depth > 2){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.remove();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            depth--;
        }
        
        while(queue.size() > 0){
            TreeNode node = queue.remove();
            
            TreeNode temp = node.left;
            TreeNode leftNewNode = new TreeNode(val);
            node.left = leftNewNode;
            leftNewNode.left = temp;
            
            temp = node.right;
            TreeNode rightNewNode = new TreeNode(val);
            node.right = rightNewNode;
            rightNewNode.right = temp;
        }
        
        return root;
    }
}