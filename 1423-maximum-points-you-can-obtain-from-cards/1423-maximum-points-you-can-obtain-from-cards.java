class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = cardPoints.length - k;
        int j = 0;
        int sum = 0;
        for(int n=i;n<cardPoints.length;n++){
            sum+=cardPoints[n];
        }

        if(k == cardPoints.length){
            return sum;
        }

        int max = sum;
        while(j<k){
            sum += (cardPoints[j++] - cardPoints[i++]);
            max = Math.max(max, sum);
        }

        return max;
    }
}