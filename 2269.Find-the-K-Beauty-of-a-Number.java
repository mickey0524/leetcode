// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
// algorithms
// Easy (55.72%)
// Total Accepted: 10,777
// Total Submissions: 19,341

class Solution {

    public int divisorSubstrings(int num, int k) {
        int res = 0;
        int a = 0, b;
        int base = 1;
        int initNum = num;

        for (int i = 0; i < k - 1; i++) {
            a += base * (num % 10);
            num /= 10;
            base *= 10;
        }
        while (num != 0) {
            b = num % 10;
            num /= 10;
            int tmp = b * base + a;

            if (checkBeauty(initNum, tmp)) {
                res++;
            }

            a = tmp / 10;
        }

        return res;
    }

    private boolean checkBeauty(int num, int a) {
        return a > 0 && num % a == 0;
    }

}