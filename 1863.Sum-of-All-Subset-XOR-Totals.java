// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
// algorithms
// Easy (77.93%)
// Total Accepted: 13,705
// Total Submissions: 17,587


class Solution {

    private static final char SEPARATOR = '_';

    private static int res;

    public int subsetXORSum(int[] nums) {
        res = 0;

        recursive(nums, 0, 0, new ArrayList<>());
        
        return res;
    }

    private void recursive(int[] nums, int idx, int curSum, List<Integer> path) {
        res += curSum;

        int len = nums.length;
        for (int i = idx; i < len; i++) {
            path.add(nums[i]);
            recursive(nums, i + 1, curSum ^ nums[i], path);
            path.remove(path.size() - 1);
        }
    }

}