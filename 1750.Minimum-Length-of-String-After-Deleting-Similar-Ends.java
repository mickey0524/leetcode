// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
// algorithms
// Medium (42.21%)
// Total Accepted: 6,122
// Total Submissions: 14,502


class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        char[] chArr = s.toCharArray();

        int i = 0, j = len - 1;
        while (i < j) {
            if (chArr[i] != chArr[j]) {
                break;
            }

            int head = i;
            while (head < j && chArr[head] == chArr[i]) {
                head++;
            }
            int tail = j;
            while (tail >= head && chArr[tail] == chArr[j]) {
                tail--;
            }

            i = head;
            j = tail;
        }

        return Math.max(0, j - i + 1);
    }
}