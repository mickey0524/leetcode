// https://leetcode.com/problems/3sum-closest/
//
// algorithms
// Medium (45.77%)
// Total Accepted: 348,553
// Total Submissions: 761,432
// beats 100.0% of java submissions


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        boolean positive = true;
        
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if ((s - target) < res) {
                        res = s - target;
                        positive = true;
                    }
                    k--;
                } else {
                    if ((target - s) < res) {
                        res = target - s;
                        positive = false;
                    }
                    j++;
                }
            }
        }
        
        return positive ? target + res : target - res;
    }
}