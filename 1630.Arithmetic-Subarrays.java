// https://leetcode.com/problems/arithmetic-subarrays/
// algorithms
// Medium (79.55%)
// Total Accepted: 7,626
// Total Submissions: 9,587
// beats 100.0% of java submissions


class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> res = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            int[] tmp = new int[r[i] - l[i] + 1];
            for (int j = l[i]; j <= r[i]; j++) {
                tmp[j - l[i]] = nums[j];
            }
            Arrays.sort(tmp);

            res.add(isArithmetic(tmp));
        }

        return res;
    }

    private boolean isArithmetic(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return false;
        }

        int diff = arr[1] - arr[0];
        for (int i = 2; i < len; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}