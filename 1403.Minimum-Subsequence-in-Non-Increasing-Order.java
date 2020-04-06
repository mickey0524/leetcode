// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
// algorithms
// Easy (72.67%)
// Total Accepted: 7,712
// Total Submissions: 10,613
// beats 100.0% of java submissions


class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int target = sum / 2 + 1;

        Arrays.sort(nums);
        int len = nums.length;
        int curSum = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            curSum += nums[i];
            l.add(nums[i]);
            if (curSum >= target) {
                break;
            }
        }

        return l;
    }
}