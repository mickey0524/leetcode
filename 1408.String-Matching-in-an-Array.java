// https://leetcode.com/problems/string-matching-in-an-array/
// algorithms
// Easy (58.6%)
// Total Accepted: 9,208
// Total Submissions: 15,713
// beats 100.0% of java submissions


class Solution {
    public List<String> stringMatching(String[] words) {
        int len = words.length;
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());

        List<String> res = new ArrayList<>();
        for (int i = len - 2; i >= 0; i--) {
            int wordLen = words[i].length();
            for (int j = i + 1; j < len; j++) {
                if (words[j].length() == wordLen) {
                    continue;
                }

                if (words[j].indexOf(words[i]) != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }
}