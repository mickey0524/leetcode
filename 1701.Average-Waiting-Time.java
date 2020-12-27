// https://leetcode.com/problems/average-waiting-time/
// algorithms
// Medium (59.64%)
// Total Accepted: 3,935
// Total Submissions: 6,598


class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitSum = 0;
        int len = customers.length;
        
        int beginTime = customers[0][0];
        for (int[] c : customers) {
            if (beginTime < c[0]) {
                beginTime = c[0];
            }
            waitSum += (c[1] + beginTime - c[0]);
            beginTime += c[1];
        }
        
        return waitSum / len;
    }
}