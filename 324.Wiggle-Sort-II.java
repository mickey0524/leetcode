// https://leetcode.com/problems/flatten-nested-list-iterator/
//
// algorithms
// Medium (27.97%)
// Total Accepted:    58,339
// Total Submissions: 209,307
// beats 99.76% of java submissions


class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int tmp[] = Arrays.copyOf(nums, len);
        
        Arrays.sort(tmp);
        int idx = len - 1;
        for (int i = 1; i < len; i += 2) {
            nums[i] = tmp[idx--];
        }
        
        for (int i = 0; i < len; i += 2) {
            nums[i] = tmp[idx--];
        }
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}