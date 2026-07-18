class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        if(prices.length <= 1)
            return max;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = max > profit ? max : profit;
                //System.out.println("Max : "+max+" i : "+prices[i]+" j : "+ prices[j]);
            }
        }

        return max;
    }
}
