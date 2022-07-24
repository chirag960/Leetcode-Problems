/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        Set<TreeNode> set = new HashSet<>();
        TreeNode curr = root;
        while(curr != p){
            set.add(curr);
            if(p.val == curr.val)
                break;
            if(p.val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        set.add(curr);
        System.out.println("This is set");
        for(TreeNode t : set){
            System.out.println(t.val);    
        }
        
        
        TreeNode prev = root;
        curr = root;
        while(set.contains(curr)){
            prev = curr;
            if(q.val == curr.val)
                break;
            if(q.val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return prev;
    }
    
    
}