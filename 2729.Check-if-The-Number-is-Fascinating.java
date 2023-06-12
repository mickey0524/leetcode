// https://leetcode.com/problems/check-if-the-number-is-fascinating/
// algorithms
// Easy (51.6%)
// Total Accepted: 19.7K
// Total Submissions: 38.2K


class Solution {

    public boolean isFascinating(int n) {
        int twoN = n * 2;
        int threeN = n * 3;

        String nStr = String.valueOf(n);
        String twoNStr = String.valueOf(twoN);
        String threeNStr = String.valueOf(threeN);

        String concatenation = nStr + twoNStr + threeNStr;
        int[] arr = new int[10];

        for (char ch : concatenation.toCharArray()) {
            if (ch == '0') {
                return false;
            }
            if (arr[ch - '0'] > 0) {
                return false;
            }
            arr[ch - '0'] = 1;
        }

        return true;
    }

}