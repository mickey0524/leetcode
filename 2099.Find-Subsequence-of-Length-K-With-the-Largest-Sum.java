// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
// algorithms
// Easy (40.83%)
// Total Accepted: 4.9K
// Total Submissions: 12K


class Solution {

    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        
        int[][] tmp = new int[k][2];
        int idx = 0;
        for (int i = len - 1; i >= len - k; i--) {
            tmp[idx++] = arr[i];
        }

        int[] res = new int[k];
        Arrays.sort(tmp, Comparator.comparingInt(o -> o[1]));
        idx = 0;
        for (int i = 0; i < k; i++) {
            res[idx++] = tmp[i][0];
        }
        
        return res;
    }

}