// https://leetcode.com/problems/keep-multiplying-found-values-by-two/
// algorithms
// Easy (72.41%)
// Total Accepted: 11,915
// Total Submissions: 16,456


class Solution {

    public int findFinalValue(int[] nums, int original) {
        int[] arr = new int[1001];
        for (int n : nums) {
            arr[n] = 1;
        }
        
        while (original < 1001 && arr[original] == 1) {
            original <<= 1;
        }
        
        return original;
    }

}