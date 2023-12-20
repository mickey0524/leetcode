// https://leetcode.com/problems/find-common-elements-between-two-arrays/
// algorithms
// Easy (80.53%)
// Total Accepted: 21.1K
// Total Submissions: 26.2K

import java.util.*;

class Solution {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            map2.put(n, map1.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[2];
        for (int n : nums1) {
            if (map2.getOrDefault(n, 0) >= 1) {
                res[0] += 1;
            }
        }
        for (int n : nums2) {
            if (map1.getOrDefault(n, 0) >= 1) {
                res[1] += 1;
            }
        }

        return res;
    }

}