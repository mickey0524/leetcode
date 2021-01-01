// https://leetcode.com/problems/count-of-matches-in-tournament/
// algorithms
// Medium (88.49%)
// Total Accepted: 10,176
// Total Submissions: 11,499


class Solution {
    public int minPartitions(String n) {
        int res = 0;

        for (char ch : n.toCharArray()) {
            res = Math.max(res, ch - '0');
        }

        return res;
    }
}