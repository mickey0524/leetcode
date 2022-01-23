// https://leetcode.com/problems/rearrange-array-elements-by-sign/
// algorithms
// Easy (81.95%)
// Total Accepted: 9,478
// Total Submissions: 11,565


class Solution {
    
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        int positiveIdx = 0, negativeIdx = 0;
        for (int i = 0; i < len / 2; i++) {
            for (; positiveIdx < len; positiveIdx++) {
                if (nums[positiveIdx] > 0) {
                    res[2 * i] = nums[positiveIdx++];
                    break;
                }
            } 
            
            for (; negativeIdx < len; negativeIdx++) {
                if (nums[negativeIdx] < 0) {
                    res[2 * i + 1] = nums[negativeIdx++];
                    break;
                }
            } 
        }
        
        return res;
    }
    
}