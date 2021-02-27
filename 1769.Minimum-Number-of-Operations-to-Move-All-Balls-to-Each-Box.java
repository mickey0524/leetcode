// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
// algorithms
// Medium (89.33%)
// Total Accepted: 12,263
// Total Submissions: 13,728


class Solution {
    public int[] minOperations(String boxes) {
        char[] chArr = boxes.toCharArray();
        int len = chArr.length;
        int[] left2right = new int[len];
        
        int tmp = 0;
        for (int i = 1; i < len; i++) {
            left2right[i] = left2right[i - 1] + (chArr[i - 1] - '0') + tmp;
            if (chArr[i - 1] == '1') {
                tmp++;
            }
        }
        
        int[] right2left = new int[len];
        tmp = 0;
        for (int i = len - 2; i >= 0; i--) {
            right2left[i] = right2left[i + 1] + (chArr[i + 1] - '0') + tmp;
            if (chArr[i + 1] == '1') {
                tmp++;
            }
        }
        
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left2right[i] + right2left[i];
        }
        
        return res;
    }
}