// https://leetcode.com/problems/decompress-run-length-encoded-list/
// algorithms
// Easy (81.36%)
// Total Accepted: 2,505
// Total Submissions: 3,079
// beats 100.0% of java submissions


class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < (len >>> 1); i++) {
            int a = nums[2 * i];
            int b = nums[2 * i + 1];

            for (int j = 0; j < a; j++) {
                l.add(b);
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }
}