// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
// algorithms
// Easy (67.28%)
// Total Accepted: 8,395
// Total Submissions: 12,478
// beats 100.0% of java submissions


class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] wordArr = sentence.split(" ");
        int len = wordArr.length;
        int searchWordLen = searchWord.length();

        for (int i = 0; i < len; i++) {
            int wordLen = wordArr[i].length();
            if (wordLen < searchWordLen) {
                continue;
            }

            String tmp = wordArr[i].substring(0, searchWordLen);
            if (tmp.equals(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}