// https://leetcode.com/problems/intersection-of-two-arrays/
//
// algorithms
// Easy (57.97%)
// Total Accepted: 274,834
// Total Submissions: 474,092


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, true);
        }

        List<Integer> l = new ArrayList<>();
        for (int n : nums2) {
            if (map.getOrDefault(n, false)) {
                l.add(n);
                map.put(n, false);
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }
}