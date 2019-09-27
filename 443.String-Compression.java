// https://leetcode.com/problems/string-compression/
//
// algorithms
// Easy (38.45%)
// Total Accepted:    67,153
// Total Submissions: 174,636
// beats 100.0% of java submissions


class Solution {
    public int compress(char[] chars) {
        int length = chars.length;
        int i = 0, j = -1, idx = 0;
        
        while (i < length) {
            j = i + 1;
            while (j < length && chars[j] == chars[i]) {
                j += 1;
            }
            
            int repeatNum = j - i;
            if (repeatNum == 1) {
                chars[idx++] = chars[i];
            } else {
                chars[idx++] = chars[i];
                char[] tmp = String.valueOf(repeatNum).toCharArray();
                for (int k = 0; k < tmp.length; k++) {
                    chars[idx++] = tmp[k];
                }
            }
            
            i = j;
        }
        
        return idx;
    }
}