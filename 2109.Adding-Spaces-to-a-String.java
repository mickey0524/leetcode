// https://leetcode.com/problems/adding-spaces-to-a-string/
// algorithms
// Medium (52.64%)
// Total Accepted: 6,877
// Total Submissions: 13,063


class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        
        int preIdx = 0;
        for (int idx : spaces) {
            sb.append(s.substring(preIdx, idx));
            sb.append(" ");
            preIdx = idx;
        }
        sb.append(s.substring(preIdx));
        
        return sb.toString();
    }
}