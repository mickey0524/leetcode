// https://leetcode.com/problems/rotated-digits/
//
// algorithms
// Easy (56.30%)
// Total Accepted: 40,723
// Total Submissions: 72,324


class Solution {
    public int rotatedDigits(int N) {
        int[] goodNum = new int[10];
        for (int n : new int[] { 0, 1, 8 }) {
            goodNum[n] = 1;
        }
        for (int n : new int[] { 2, 5, 6, 9 }) {
            goodNum[n] = 2;
        }

        boolean diff, isGood;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            diff = false;
            isGood = true;

            String tmp = String.valueOf(i);
            for (char ch : tmp.toCharArray()) {
                int flag = goodNum[ch - '0'];
                if (flag == 0) {
                    isGood = false;
                    break;
                }
                if (flag == 2) {
                    diff = true;
                }
            }

            if (isGood && diff) {
                res++;
            }
        }

        return res;
    }
}