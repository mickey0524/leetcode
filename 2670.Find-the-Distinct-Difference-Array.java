// https://leetcode.com/problems/find-the-distinct-difference-array/
// algorithms
// Easy (76.47%)
// Total Accepted: 15.6K
// Total Submissions: 20.4K

class Solution {

    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] l2r = new int[len];
        int[] r2l = new int[len];
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            l2r[i] = set.size();
        }
        set.clear();
        for (int i = len - 2; i >= 0; i--) {
            set.add(nums[i + 1]);
            r2l[i] = set.size();
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = l2r[i] - r2l[i];
        }

        return res;
    }

}