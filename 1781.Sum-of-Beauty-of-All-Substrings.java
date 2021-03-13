// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
// algorithms
// Medium (56.48%)
// Total Accepted: 5,878
// Total Submissions: 10,408


class Solution {
    public int beautySum(String s) {
        int res = 0;
        char[] chArr = s.toCharArray();
        int size = chArr.length;

        for (int i = 3; i <= size; i++) {
            int[] tmp = new int[26];
            for (int j = 0; j < i; j++) {
                tmp[chArr[j] - 'a']++;
            }

            res += calculate(tmp);
            for (int j = i; j < size; j++) {
                tmp[chArr[j] - 'a']++;
                tmp[chArr[j - i] - 'a']--;
                res += calculate(tmp);
            }
        }
        
        return res;
    }

    private int calculate(int[] tmp) {
        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;

        for (int n : tmp) {
            if (n == 0) {
                continue;
            }
            
            maxNum = Math.max(n, maxNum);
            minNum = Math.min(n, minNum);
        }

        return maxNum - minNum;
    }
}