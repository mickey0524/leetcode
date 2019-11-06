// https://leetcode.com/problems/relative-ranks/
//
// algorithms
// Easy (49.12%)
// Total Accepted: 47,373
// Total Submissions: 96,434


class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[][] arr = new int[len][2];

        for (int i = 0; i < len; i++) {
            arr[i] = new int[] { nums[i], i };
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        String[] res = new String[len];
        for (int i = 0; i < Math.min(3, len); i++) {
            if (i == 0) {
                res[arr[i][1]] = "Gold Medal";
            } else if (i == 1) {
                res[arr[i][1]] = "Silver Medal";
            } else {
                res[arr[i][1]] = "Bronze Medal";
            }
        }

        for (int i = 3; i < len; i++) {
            res[arr[i][1]] = String.valueOf(i + 1);
        }

        return res;
    }
}