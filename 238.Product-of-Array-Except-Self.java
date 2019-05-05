// https://leetcode.com/problems/product-of-array-except-self/
//
// algorithms
// Medium (54.70%)
// Total Accepted:    248,998
// Total Submissions: 455,179
// beats 100.0% of java submissions


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length, s = 1;
        int res[] = new int[length];
        
        for (int i = 1; i < length; i++) {
            s *= nums[i - 1];
            res[i] = s;
        }
        
        s = 1;
        res[0] = 1;
        
        for (int i = length - 2; i >= 0; i--) {
            s *= nums[i + 1];
            res[i] *= s;
        }
        
        return res;
    }
}