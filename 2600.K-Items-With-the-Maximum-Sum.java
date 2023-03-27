// https://leetcode.com/problems/k-items-with-the-maximum-sum/
// algorithms
// Easy (61.63%)
// Total Accepted: 15.9K
// Total Submissions: 25.8K


class Solution {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        
        if (k <= numOnes) {
            return k;
        }

        res = numOnes;
        k -= numOnes;

        if (k <= numZeros) {
            return res;
        }

        k -= numZeros;

        return res - k;
    }

}