// https://leetcode.com/problems/rearrange-spaces-between-words/
// algorithms
// Easy (43.87%)
// Total Accepted: 10,623
// Total Submissions: 24,212
// beats 100.0% of java submissions


class Solution {

    private static final char BLANK = ' ';

    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();

        int blankNum = 0;
        int len = text.length();
        char[] chArr = text.toCharArray();
        int idx = 0, preIdx = -1;
        List<String> l = new ArrayList<>();

        while (idx < len) {
            if (chArr[idx] == BLANK) {
                blankNum++;
                idx++;
            } else {
                int j = idx + 1;
                while (j < len && chArr[j] != BLANK) {
                    j++;
                }
                l.add(text.substring(idx, j));
                idx = j;
            }
        }

        int intervalNum = -1, endNum = -1;
        if (l.size() == 1) {
            intervalNum = 0;
            endNum = blankNum;
        } else {
            intervalNum = blankNum / (l.size() - 1);
            endNum = blankNum - intervalNum * (l.size() - 1);
        }

        sb.append(l.get(0));
        for (int i = 1; i < l.size(); i++) {
            for (int j = 0; j < intervalNum; j++) {
                sb.append(BLANK);
            }
            sb.append(l.get(i));
        }

        for (int j = 0; j < endNum; j++) {
            sb.append(BLANK);
        }

        return sb.toString();
    }
}