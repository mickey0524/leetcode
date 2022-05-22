// https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
// algorithms
// Medium (17.37%)
// Total Accepted: 7.8K
// Total Submissions: 44.9K


class Solution {
    
    public int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length;
        if (len < 3) {
            return len - 1;
        }
        
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
        
        int res = 1;
        for (int i = 2; i < len; i++) {
            if ((stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0]) == 
                            (stockPrices[i - 1][1] - stockPrices[i - 2][1]) * (stockPrices[i][0] - stockPrices[i - 1][0])) continue;
            res++;
        }
        
        return res;
    }
    
}