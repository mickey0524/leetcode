// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
// algorithms
// Easy (72.9%)
// Total Accepted: 21.8K
// Total Submissions: 29.9K

class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;

        List<int[]> list = new ArrayList<>();
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1][0] < nums2[idx2][0]) {
                list.add(nums1[idx1]);
                idx1++;
            } else if (nums1[idx1][0] > nums2[idx2][0]) {
                list.add(nums2[idx2]);
                idx2++;
            } else {
                list.add(new int[]{nums1[idx1][0], nums1[idx1][1] + nums2[idx2][1]});
                idx1++;
                idx2++;
            }
        }

        for (; idx1 < len1; idx1++) {
            list.add(nums1[idx1]);
        }

        for (; idx2 < len2; idx2++) {
            list.add(nums2[idx2]);
        }

        int[][] res = new int[list.size()][2];
        int idx = 0;
        for (int[] p : list) {
            res[idx] = list.get(idx);
            idx++;
        }

        return res;
    }

}