//2020-03-09 19:16:02
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for(int i:prices){
            if(i<min)
                min = i;
            else
                maxProfit = Math.max(maxProfit, i-min);
        }
        return maxProfit;
    }
}
//2020-03-09 19:22:06