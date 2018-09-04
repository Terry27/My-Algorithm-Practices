class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] res = new int[prices.length];
        int maxVal = 0, output = 0;
        for(int i = prices.length-2; i >=0; i--){
            maxVal = Math.max(maxVal,prices[i+1]);
            output = Math.max(maxVal - prices[i], output);
        }
        return output;
    }
}