// https://leetcode.com/problems/shuffle-an-array/
//
// algorithms
// Medium (49.88%)
// Total Accepted:    74,127
// Total Submissions: 148,648


class Solution {

    private int[] nums;
        
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] curNums = this.nums.clone();
        int length = curNums.length;
        int tail = length;
        
        Random random = new Random();
        
        for (int i = 0; i < length - 1; i++) {
            int idx = random.nextInt(tail);
            swap(curNums, idx, tail - 1);
            tail--;
        }
        
        return curNums;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */