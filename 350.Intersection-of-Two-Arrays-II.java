// https://leetcode.com/problems/intersection-of-two-arrays-ii/
//
// algorithms
// Medium (47.49%)
// Total Accepted:    194,819
// Total Submissions: 410,222


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        if (len1 < len2) {
            return intersect1(nums2, nums1);
        }

        return intersect1(nums1, nums2);
    }

    public int[] intersect1(int[] more, int[] less) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i : less) {
            if (map.containsKey(i)) {
                map.get(i)[0]++;
            } else {
                map.put(i, new int[]{1, 0});
            }
        }

        for (int i : more) {
            if (map.containsKey(i)) {
                map.get(i)[1]++;
            }
        }

        ArrayList<Integer> l = new ArrayList<>();

        for (Map.Entry entry : map.entrySet()) {
            int k = (int) entry.getKey();
            int[] v = (int[]) entry.getValue();
            for (int i = 0; i < Math.min(v[0], v[1]); i++) {
                l.add(k);
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }
}