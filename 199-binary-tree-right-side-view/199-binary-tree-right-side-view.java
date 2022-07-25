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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(i==0)
                    result.add(node.val);        
                if(node.right!=null)
                    queue.add(node.right);
                if(node.left!=null)
                    queue.add(node.left);
            }
        }
        
        return result;
    }
}