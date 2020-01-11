// https://leetcode.com/problems/count-number-of-nice-subarrays/
//
// algorithms
// Medium (53.61%)
// Total Accepted: 7,307
// Total Submissions: 13,630
// beats 100.0% of java submissions


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int curOddNum = 0;
        int pre = 0, firstOddIdx = -1, lastOddIdx = -1, res = 0;

        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                if (firstOddIdx == -1) {
                    firstOddIdx = i;
                }
                if (curOddNum == k - 1) {
                    lastOddIdx = i;
                    curOddNum++;
                } else if (curOddNum == k) {
                    res += (i - lastOddIdx) * (firstOddIdx - pre + 1);

                    pre = firstOddIdx + 1;
                    lastOddIdx = i;
                    for (int j = pre; j <= i; j++) {
                        if ((nums[j] & 1) == 1) {
                            firstOddIdx = j;
                            break;
                        }
                    }
                } else {
                    curOddNum++;
                }
            }
        }

        if (curOddNum == k) {
            res += (len - lastOddIdx) * (firstOddIdx - pre + 1);
        }

        return res;
    }
}