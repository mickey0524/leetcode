// https://leetcode.com/problems/create-target-array-in-the-given-order/
// algorithms
// Easy (81.86%)
// Total Accepted: 12,003
// Total Submissions: 14,662


class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < len; i++) {
            int targetIdx = index[i];
            if (res[targetIdx] != -1) {
                stepForword(res, targetIdx, i);
            }

            res[targetIdx] = nums[i];
        }

        return res;
    }

    private void stepForword(int[] nums, int beginIdx, int endIdx) {
        for (int i = endIdx; i > beginIdx; i--) {
            nums[i] = nums[i - 1];
        }
    }
}