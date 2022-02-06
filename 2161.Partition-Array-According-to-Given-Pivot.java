// https://leetcode.com/problems/partition-array-according-to-given-pivot/
// algorithms
// Medium (78.96%)
// Total Accepted: 9,730
// Total Submissions: 12,323


class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessList = new ArrayList<>();
        List<Integer> greaterList = new ArrayList<>();
        int pivotNum = 0;
        
        for (int n : nums) {
            if (n == pivot) {
                pivotNum++;
            } else if (n > pivot) {
                greaterList.add(n);
            } else {
                lessList.add(n);
            }
        }
        
        int idx = 0;
        for (int n : lessList) {
            nums[idx++] = n;
        }
        for (int i = 0; i < pivotNum; i++) {
            nums[idx++] = pivot;
        }
        for (int n : greaterList) {
            nums[idx++] = n;
        }
        
        return nums;
    }
}