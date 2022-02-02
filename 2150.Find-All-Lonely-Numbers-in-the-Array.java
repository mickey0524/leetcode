// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
// algorithms
// Medium (60.11%)
// Total Accepted: 17,861
// Total Submissions: 29,712


class Solution {
    public List<Integer> findLonely(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return Arrays.asList(nums[0]);
        }
        
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[1] != nums[0] && nums[1] - nums[0] != 1) {
            res.add(nums[0]);
        }
        
        int idx = 1;
        while (idx < len - 1) {
            if (nums[idx] - nums[idx - 1] != 1
                && nums[idx + 1] - nums[idx] != 1
                && nums[idx] != nums[idx - 1]
                && nums[idx] != nums[idx + 1]) {
                res.add(nums[idx]);
            }
            
            idx++;
        }
        
        if (nums[len - 1] != nums[len - 2] && nums[len - 1] - nums[len - 2] != 1) {
            res.add(nums[len - 1]);
        }
        
        return res;
    }
}