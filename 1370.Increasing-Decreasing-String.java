// https://leetcode.com/problems/increasing-decreasing-string/
// algorithms
// Easy (79.32%)
// Total Accepted: 3,683
// Total Submissions: 4,643
// beats 100.0% of java submissions


class Solution {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] charNum = new int[26];

        for (char ch : s.toCharArray()) {
            charNum[ch - 'a']++;
        }

        boolean isFound = false;
        int left = 0, right = 25;
        while (true) {
            isFound = false;

            int rightTmp = right;
            for (int i = left; i <= right; i++) {
                if (charNum[i] > 0) {
                    charNum[i]--;
                    sb.append((char) (i + 'a'));
                    isFound = true;
                    rightTmp = i;
                }
            }
            right = rightTmp;

            int leftTmp = left;
            for (int i = right; i >= left; i--) {
                if (charNum[i] > 0) {
                    charNum[i]--;
                    sb.append((char) (i + 'a'));
                    isFound = true;
                    leftTmp = i;
                }
            }
            left = leftTmp;

            if (!isFound) {
                break;
            }
        }

        return sb.toString();
    }
}