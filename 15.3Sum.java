// https://leetcode.com/problems/3sum/
//
// algorithms
// Medium (23.97%)
// Total Accepted: 546,654
// Total Submissions: 2,280,298


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length, i = 0;

        while (i < len) {
            int j = i + 1, k = len - 1, target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
            while (i < len && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return res;
    }
}