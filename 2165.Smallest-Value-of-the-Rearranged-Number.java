// https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
// algorithms
// Medium (50.25%)
// Total Accepted: 16,239
// Total Submissions: 32,314


class Solution {
    
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0L;
        }
        
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        
        String str = String.valueOf(num);
        char[] chArr = str.toCharArray();
        
        if (negative) {
            return -1 * maxNum(chArr);
        }
        
        return minNum(chArr);
    }
    
    private long minNum(char[] chArr) {
        Arrays.sort(chArr);
        int len = chArr.length;
        int zeroNum = 0;
        int idx = 0;
        
        for (; idx < len; idx++) {
            if (chArr[idx] == '0') {
                zeroNum++;
            } else {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(chArr[idx++]);
        for (int i = 0; i < zeroNum; i++) {
            sb.append('0');
        }
        
        for (; idx < len; idx++) {
            sb.append(chArr[idx]);
        }
        
        return Long.parseLong(sb.toString());
    }
    
    private long maxNum(char[] chArr) {
        Arrays.sort(chArr);
        StringBuilder sb = new StringBuilder();
        int len = chArr.length;
        
        for (int i = len - 1; i >= 0; i--) {
            sb.append(chArr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
    
}