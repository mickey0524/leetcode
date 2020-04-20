// https://leetcode.com/problems/reformat-the-string/
// algorithms
// Easy (55.91%)
// Total Accepted: 8,926
// Total Submissions: 15,965
// beats 100.0% of java submissions


class Solution {

    private static final String EMPTY_RES = "";

    public String reformat(String s) {
        int len = s.length();
        if (len == 0) {
            return EMPTY_RES;
        }

        ArrayList<Character> digitCharArr = new ArrayList<>(len);
        ArrayList<Character> letterCharArr = new ArrayList<>(len);

        for (char ch : s.toCharArray()) {
            if (isDigit(ch)) {
                digitCharArr.add(ch);
            } else {
                letterCharArr.add(ch);
            }
        }

        int digitNum = digitCharArr.size();
        int letterNum = letterCharArr.size();
        int charNumDiff = digitNum - letterNum;
        if (charNumDiff > 1 || charNumDiff < -1) {
            return EMPTY_RES;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(digitNum, letterNum); i++) {
            sb.append(digitCharArr.get(i)).append(letterCharArr.get(i));
        }

        if (charNumDiff == 1) {
            sb.append(digitCharArr.get(digitNum - 1));
        } else if (charNumDiff == -1) {
            sb.insert(0, letterCharArr.get(letterNum - 1));
        }

        return sb.toString();
    }

    private boolean isDigit(char ch) {
        int diff = ch - '0';

        return diff >= 0 && diff <= 9;
    }

}