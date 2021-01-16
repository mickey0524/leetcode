// https://leetcode.com/problems/maximum-score-from-removing-substrings/
// algorithms
// Easy (37.47%)
// Total Accepted: 3,920
// Total Submissions: 10,461


class Solution {
    
    public int maximumGain(String s, int x, int y) {
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int res = 0;
        
        if (x >= y) {
            Object[] tmp = iterate(s, x, "ab");
            res += (int) tmp[1];
            tmp = iterate((String) tmp[0], y, "ba");
            res += (int) tmp[1];
        } else {
            Object[] tmp = iterate(s, y, "ba");
            res += (int) tmp[1];
            tmp = iterate((String) tmp[0], x, "ab");
            res += (int) tmp[1];
        }
        
        return res;
    }
    
    private Object[] iterate(String s, int score, String target) {
        Object[] arr = new Object[2];
        StringBuilder sb = new StringBuilder();
        int res = 0;
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && chArr[i] == target.charAt(0) && chArr[i + 1] == target.charAt(1)) {
                res += score;
                i++;
            } else if (sb.length() > 0 && chArr[i] == target.charAt(1) &&
                      target.charAt(0) == sb.charAt(sb.length() - 1)) {
                res += score;
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(chArr[i]);
            }
        }
        
        arr[0] = sb.toString();
        arr[1] = res;
        
        return arr;
    }
    
}