// https://leetcode-cn.com/problems/closed-number-lcci/
// algorithms
// Easy (41.52%)
// Total Accepted: 1,095
// Total Submissions: 2,637


class Solution {

    private static final int MIN_VALUE = 1;

    public int[] findClosedNumbers(int num) {
        int[] res = new int[2];
        res[0] = getBigger(num);
        res[1] = getSmaller(num);

        return res;
    }

    private int getBigger(int num) {
        if (num == Integer.MAX_VALUE) {
            return -1;
        }

        String binaryStr = zfill(Integer.toBinaryString(num), 31, '0');
        char[] chArr = binaryStr.toCharArray();

        int zeroIdx = -1, oneNum = 0;
        for (int i = 30; i >= 0; i--) {
            if (chArr[i] == '1') {
                oneNum++;
            } else if (oneNum != 0) {
                zeroIdx = i;
                break;
            }
        }
        if (zeroIdx == -1) {
            return -1;
        }
        chArr[zeroIdx] = '1';
        int idx = 30;
        for (int i = 0; i < oneNum - 1; i++) {
            chArr[idx--] = '1';
        }
        for (int i = idx; i > zeroIdx; i--) {
            chArr[i] = '0';
        }

        return Integer.parseInt(new String(chArr), 2);
    }

    private int getSmaller(int num) {
        if (num == Integer.MAX_VALUE || num == MIN_VALUE) {
            return -1;
        }

        String binaryStr = zfill(Integer.toBinaryString(num), 31, '0');
        char[] chArr = binaryStr.toCharArray();
        int zeroIdx = -1, oneNum = 0;
        for (int i = 30; i >= 0; i--) {
            if (chArr[i] == '0') {
                zeroIdx = i;
                break;
            } else {
                oneNum++;
            }
        }

        int oneIdx = -1;
        for (int i = zeroIdx - 1; i >= 0; i--) {
            if (chArr[i] == '1') {
                oneIdx = i;
                break;
            }
        }

        if (oneIdx == -1) {
            return -1;
        }
        chArr[oneIdx] = '0';
        chArr[oneIdx + 1] = '1';
        int idx = oneIdx + 2;
        for (int i = 0; i < oneNum; i++) {
            chArr[idx++] = '1';
        }

        for (int i = idx; i < 31; i++) {
            chArr[i] = '0';
        }

        return Integer.parseInt(new String(chArr), 2);
    }

    private String zfill(String str, int targetLen, char ch) {
        int curLen = str.length();
        if (curLen == targetLen) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetLen - curLen; i++) {
            sb.append(ch);
        }
        sb.append(str);

        return sb.toString();
    }

}