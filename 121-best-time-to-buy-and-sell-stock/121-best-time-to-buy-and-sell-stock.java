class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int curr_profit; 
        int i=0;
        int min_sell = prices[i];
        int j=1;
        while(j < prices.length){
            if(prices[i] > prices[j]){
                if(prices[j] < min_sell){
                    i=j;    
                }
                j++;
            }
            else{
                curr_profit = prices[j] - prices[i];
                max_profit = Math.max(curr_profit, max_profit);
                j++;
            }
        }
        return max_profit;
    }
}