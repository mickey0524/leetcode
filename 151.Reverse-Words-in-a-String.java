// https://leetcode.com/problems/reverse-words-in-a-string/
//
// algorithms
// Medium (16.66%)
// Total Accepted: 278,511
// Total Submissions: 1,671,762

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();

        String[] strArr = s.split("\\s+");
        int len = strArr.length;

        for (int i = len - 1; i > 0; i--) {
            sb.append(strArr[i]).append(" ");
        }

        if (len > 0) {
            sb.append(strArr[0]);
        }

        return sb.toString();
    }
}