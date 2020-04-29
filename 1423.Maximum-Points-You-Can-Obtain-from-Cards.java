// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// algorithms
// Medium (37.44%)
// Total Accepted: 8,216
// Total Submissions: 21,943
// beats 100.0% of java submissions


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] leftToRight = new int[k];
        int[] rightToLeft = new int[k];

        leftToRight[0] = cardPoints[0];
        for (int i = 1; i < k; i++) {
            leftToRight[i] = leftToRight[i - 1] + cardPoints[i];
        }

        rightToLeft[0] = cardPoints[len - 1];
        for (int i = len - 2; i > len - 1 - k; i--) {
            int idx = len - 1 - i;
            rightToLeft[len - 1 - i] = rightToLeft[idx - 1] + cardPoints[i];
        }

        int res = Math.max(leftToRight[k - 1], rightToLeft[k - 1]);
        for (int i = 0; i < k - 1; i++) {
            res = Math.max(res, leftToRight[i] + rightToLeft[k - 2 - i]);
        }

        return res;
    }
}