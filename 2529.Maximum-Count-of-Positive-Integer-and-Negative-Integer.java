// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
// algorithms
// Easy (77.5%)
// Total Accepted: 32.7K
// Total Submissions: 42.2K


class Solution {

    public int maximumCount(int[] nums) {
        int len = nums.length;
        int[] leftZeroIdx = findLeftZeroIdx(nums);
        System.out.println(leftZeroIdx[0]);
        System.out.println(leftZeroIdx[1]);

        if (leftZeroIdx[0] == -1) {
            return len;
        }

        int rightZeroIdx = findRightZeroIdx(nums);
        System.out.println(rightZeroIdx);

        if (leftZeroIdx[0] == 0) {
            return Math.max(leftZeroIdx[1], len - 1 - rightZeroIdx);
        }

        return Math.max(leftZeroIdx[1] + 1, len - rightZeroIdx);
    }

    private int[] findLeftZeroIdx(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == 0) {
                if (m == l || nums[m - 1] < 0) {
                    return new int[]{0, m};
                }

                r = m - 1;
            } else if (nums[m] > 0) {
                r = m - 1;
            } else {
                if (m == r || nums[m + 1] >= 0) {
                    return new int[]{1, m};
                }

                l = m + 1;
            }
        }

        return new int[]{-1, 0};
    }

    private int findRightZeroIdx(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == 0) {
                if (m == r || nums[m + 1] > 0) {
                    return m;
                }

                l = m + 1;
            } else if (nums[m] > 0) {
                if (m == l || nums[m - 1] <= 0) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return 0;
    }

}