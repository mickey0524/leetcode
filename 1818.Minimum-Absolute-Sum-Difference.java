// https://leetcode.com/problems/minimum-absolute-sum-difference/
// algorithms
// Medium (44.53%)
// Total Accepted: 9,209
// Total Submissions: 20,681


class Solution {

    private static final int MODULE = 1000000007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        long sum = 0;
        int[] sortNums1 = new int[len];
        for (int i = 0; i < len; i++) {
            sortNums1[i] = nums1[i];
        }
        Arrays.sort(sortNums1);

        int delta = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            if (sum >= MODULE) {
                sum %= MODULE;
            }

            if (nums1[i] != nums2[i]) {
                int idx = binarySearch(sortNums1, nums2[i]);
                if (idx == 0) {
                    delta = Math.max(delta, diff - Math.abs(sortNums1[0] - nums2[i]));
                } else {
                    int tmp = Math.max(diff - Math.abs(sortNums1[idx] - nums2[i]), diff - Math.abs(sortNums1[idx - 1] - nums2[i]));
                    delta = Math.max(delta, tmp);
                }
            }
        }
        
        if (delta != Integer.MIN_VALUE) {
            sum -= delta;
            if (sum < 0) {
                sum += MODULE;
            }
        }
        
        return (int) sum;
    }

    private int binarySearch(int[] arr, int target) {
        int len = arr.length;
        int l = 0, r = len - 1, m;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }

        }

        return Math.min(l, len - 1);
    }

}