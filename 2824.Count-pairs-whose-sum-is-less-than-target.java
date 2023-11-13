// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
// algorithms
// Easy (86.7%)
// Total Accepted: 68.9K
// Total Submissions: 79.5K


class Solution {

    public int countPairs(List<Integer> nums, int target) {
        int len = nums.size();
        if (len < 2) {
            return 0;
        }

        if (len == 2) {
            return nums.get(0) + nums.get(1) < target ? 1 : 0;
        }

        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                }
            }
        }
        
        return res;
    }

}