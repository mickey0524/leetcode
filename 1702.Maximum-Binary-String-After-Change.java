// https://leetcode.com/problems/maximum-binary-string-after-change/
// algorithms
// Medium (63.04%)
// Total Accepted: 5,553
// Total Submissions: 8,809


class Solution {
    public String maximumBinaryString(String binary) {
        int len = binary.length();
        char[] chArr = binary.toCharArray();
        int zeroNum = 0;
        int beginIdx = -1;
        
        for (int i = 0; i < len; i++) {
            char ch = chArr[i];
            if (ch == '0') {
                zeroNum++;
                if (beginIdx == -1) {
                    beginIdx = i;
                }
            }
        }

        if (zeroNum == 0) {
            return binary;
        }

        for (int i = beginIdx; i < len; i++) {
            if ((i - beginIdx) == (zeroNum - 1)) {
                chArr[i] = '0';
            } else {
                chArr[i] = '1';
            }
        }

        return new String(chArr);
    }
}
