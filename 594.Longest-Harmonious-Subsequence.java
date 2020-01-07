// https://leetcode.com/problems/longest-harmonious-subsequence/
//
// algorithms
// Easy (45.01%)
// Total Accepted: 45,168
// Total Submissions: 100,358


class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key - 1)) {
                res = Math.max(res, map.get(key) + map.get(key - 1));
            }
        }

        return res;
    }
}