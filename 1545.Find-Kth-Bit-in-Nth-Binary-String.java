// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
// algorithms
// Medium (57.24%)
// Total Accepted: 9,734
// Total Submissions: 17,006
// beats 100.0% of java submissions


class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (int) Math.pow(2, n) - 1;
        int mid = len / 2;
        if (mid + 1 == k) {
            return '1';
        }

        if (mid + 1 > k) {
            return findKthBit(n - 1, k);
        }

        int nextLen = (int) Math.pow(2, n - 1) - 1;

        char value = findKthBit(n - 1, nextLen + 1 - (k - nextLen - 1));

        return value == '0' ? '1' : '0';
    }
}