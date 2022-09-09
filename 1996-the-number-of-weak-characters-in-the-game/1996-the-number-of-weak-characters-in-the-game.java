class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> (a[0]==b[0]) ? a[1]-b[1] : b[0]-a[0]);
        
        int max = 0;
        int result = 0;
        
        for(int i=0;i<properties.length;i++){
            if(properties[i][1] < max){
                result++;
            }
            max = Math.max(properties[i][1], max);
        }
        return result;
    }
}