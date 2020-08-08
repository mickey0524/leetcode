// https://leetcode.com/problems/number-of-good-pairs/
// algorithms
// Easy (76.87%)
// Total Accepted: 8,245
// Total Submissions: 8,981
// beats 100.0% of java submissions


class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.values()) {
            res += (1 + (n - 1)) * (n - 1) / 2;
        }

        return res;
    }
}