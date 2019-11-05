// https://leetcode.com/problems/1-bit-and-2-bit-characters/
//
// algorithms
// Easy (49.16%)
// Total Accepted: 48,601
// Total Submissions: 98,862
// beats 100.0% of java submissions


class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1) {
            return true;
        }
        if (bits[len - 2] == 0) {
            return true;
        }

        return !checkValid(bits, 0, len - 3);
    }

    public boolean checkValid(int[] bits, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (bits[i] == 1) {
                if (i == end) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}