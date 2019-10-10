// https://leetcode.com/problems/convert-bst-to-greater-tree/
//
// algorithms
// Easy (30.4%)
// Total Accepted: 75,041
// Total Submissions: 246,822
// beats 100.0% of java submissions


class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            int v = entry.getValue();

            if (k == 0) {
                if (v > 1) {
                    res++;
                }
            } else if (map.containsKey(n + k)) {
                res++;
            }
        }

        return res;
    }
}