class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] num = new int[n];
        
        for(int i = 0; i< edges.length; i++) {
            num[edges[i][1]] = 1;
        }
        
        boolean found = false;
        int ans = 0;
        int i=0;
        while(i < n) {
            if(num[i] == 0) {
                if (found) {
                    return -1;
                } else {
                    found = true;
                    ans = i;
                }
            }
            i++;
        }
        return ans;
    }
}