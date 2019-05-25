// https://leetcode.com/problems/triangle/
//
// algorithms
// Medium (39.28%)
// Total Accepted: 180,880
// Total Submissions: 460,446

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return triangle.get(0).get(0);
        }

        for (int i = 1; i < len; i++) {
            List<Integer> l = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int value = -1;
                if (j == 0) {
                    value = l.get(j) + triangle.get(i - 1).get(0);
                } else if (j == i) {
                    value = l.get(j) + triangle.get(i - 1).get(j - 1);
                } else {
                    value = l.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                l.set(j, value);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int n : triangle.get(len - 1)) {
            res = Math.min(res, n);
        }

        return res;
    }
}