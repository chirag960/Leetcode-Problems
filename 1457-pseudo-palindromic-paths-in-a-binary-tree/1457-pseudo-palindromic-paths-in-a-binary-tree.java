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
    
    public int count=0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        dfs(root, freq, 0);
        return count;
    }
    
    public void dfs(TreeNode node, int[] freq, int length){
        length++;
        freq[node.val]++;
        
        if(node.left==null && node.right==null){
            if(checkPalindrome(freq, length)){
                count++;
            }
        }
        
        if(node.left!=null){
            dfs(node.left, freq, length);    
        }
        if(node.right!=null){
            dfs(node.right, freq, length);    
        }
        length--;
        freq[node.val]--;
        
    }
    
    public boolean checkPalindrome(int[] freq, int length){
        int even = 0;
        int odd = 0;
        for(int i : freq){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        if(length%2==0 && odd==0){
            return true;
        }
        if(length%2==1 && odd==1){
            return true;
        }
        return false;
    }
}