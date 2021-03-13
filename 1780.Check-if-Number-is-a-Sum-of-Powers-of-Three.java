// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
// algorithms
// Medium (63.24%)
// Total Accepted: 6,339
// Total Submissions: 10,023


class Solution {

    private static final List<Integer> nums = new ArrayList<>();

    static {
        for (int i = 0; i < 15; i++) {
            nums.add((int) (Math.pow(3, i)));
        }
    }

    private static boolean res;

    public boolean checkPowersOfThree(int n) {
        res = false;

        recursive(0, 0, n);

        return res;
    }

    private void recursive(int idx, int curSum, int target) {
        if (res) {
            return;
        }

        if (curSum > target) {
            return;
        }

        if (curSum == target) {
            res = true;
            return;
        }

        int size = nums.size();
        for (int i = idx; i < size; i++) {
            recursive(i + 1, curSum + nums.get(i), target);
        }
    }

}