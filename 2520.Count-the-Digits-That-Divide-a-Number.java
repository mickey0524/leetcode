// https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/
// algorithms
// Easy (83.59%)
// Total Accepted: 10.7K
// Total Submissions: 12.8K


class Solution {

    public int countDigits(int num) {
        String numStr = String.valueOf(num);

        int res = 0;
        for (char ch : numStr.toCharArray()) {
            int tmp = ch - '0';
            if (num % tmp == 0) {
                res++;
            }
        }    

        return res;
    }

}