// https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
// algorithms
// Easy (70.39%)
// Total Accepted: 7,696
// Total Submissions: 10,933
// beats 100.0% of java submissions


class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][] {};
        }
        int sum = 0, left = 1, right = 0;
        ArrayList<int[]> l = new ArrayList<>();

        while (left * 2 < target) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left + 1];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = left + i;
                }
                l.add(arr);
                sum = sum -= left;
                left++;
            }
        }

        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) {
            int[] tmp = l.get(i);
            res[i] = new int[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                res[i][j] = tmp[j];
            }
        }

        return res;
    }
}