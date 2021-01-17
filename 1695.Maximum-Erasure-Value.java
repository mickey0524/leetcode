// https://leetcode.com/problems/maximum-erasure-value/
// algorithms
// Medium (49.52%)
// Total Accepted: 8,962
// Total Submissions: 18,099


class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int[] sum = new int[len + 1];
        Map<Integer, Integer> idxMap = new HashMap<>();
        int beginIdx = 0;
        
        for (int i = 0; i < len; i++) {
            Integer preIdx = idxMap.get(nums[i]);
            if (preIdx != null && preIdx >= beginIdx) {
                res = Math.max(sum[i] - sum[preIdx], res);
                beginIdx = preIdx + 1;
            } else {
                res = Math.max(sum[i] + nums[i] - sum[beginIdx], res);
            }
            
            // 记录索引
            idxMap.put(nums[i], i);
            sum[i + 1] = sum[i] + nums[i];
        }
        
        res = Math.max(res, sum[len] - sum[beginIdx]);
        
        return res;
    }
}