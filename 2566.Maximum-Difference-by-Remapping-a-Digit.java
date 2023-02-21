class Solution {

    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int numStrLen = numStr.length();

        StringBuilder maxSb = new StringBuilder();
        StringBuilder minSb = new StringBuilder();
        char maxReplaceCh = '#';
        char minReplaceCh = '#';
        for (int i = 0; i < numStrLen; i++) {
            char ch = numStr.charAt(i);
            if (ch != '9' && maxReplaceCh == '#') {
                maxReplaceCh = ch;
            }

            if (ch == maxReplaceCh) {
                maxSb.append('9');
            } else {
                maxSb.append(ch);
            }

            if (minReplaceCh == '#') {
                minReplaceCh = ch;
            }
            if (ch != minReplaceCh) {
                minSb.append(ch);
            } else if (i > 0) {
                minSb.append('0');
            }
        }
        int maxNum = Integer.valueOf(maxSb.toString());
        int minNum = minSb.length() > 0 ? Integer.valueOf(minSb.toString()) : 0;

        return maxNum - minNum;
    }

}