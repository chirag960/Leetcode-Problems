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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null)
            return maxList;
        
        maxList.add(root.val);
        if(root.left!=null){
            q.add(root.left);
        }
        if(root.right!=null){
            q.add(root.right);
        }
        
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            maxList.add(max);
        }
        return maxList;
    }
}