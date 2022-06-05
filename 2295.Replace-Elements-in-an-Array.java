// https://leetcode.com/problems/replace-elements-in-an-array/
// algorithms
// Medium (52.68%)
// Total Accepted: 10.8K
// Total Submissions: 20.5K


class Solution {
    
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> num2idx = new HashMap<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            num2idx.put(nums[i], i);
        }
        
        for (int[] o : operations) {
            int idx = num2idx.get(o[0]);
            nums[idx] = o[1];
            num2idx.put(o[1], idx);
            num2idx.remove(o[0]);
        }
        
        return nums;
    }
    
}