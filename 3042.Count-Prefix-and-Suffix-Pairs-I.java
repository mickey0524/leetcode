// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
// algorithms
// Easy (63.7%)
// Total Accepted: 30.1K
// Total Submissions: 47.3K


class Solution {

    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length;

        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int lenWordI = words[i].length();
                int lenWordJ = words[j].length();

                if (lenWordI > lenWordJ) {
                    continue;
                }

                if ((words[i].equals(words[j].substring(0, lenWordI))) &&
                    (words[i].equals(words[j].substring(lenWordJ - lenWordI, lenWordJ)))) {
                    res += 1;
                }
            }
        }

        return res;
    }

}