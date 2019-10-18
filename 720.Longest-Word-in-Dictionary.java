// https://leetcode.com/problems/longest-word-in-dictionary/
//
// algorithms
// Easy (46.08%)
// Total Accepted: 43,516
// Total Submissions: 94,440


class Solution {

    static String res;

    public String longestWord(String[] words) {
        res = "";
        int maxWordLen = Integer.MIN_VALUE;
        for (String w : words) {
            int wLen = w.length();
            if (wLen > maxWordLen) {
                maxWordLen = wLen;
            }
        }

        HashSet[] setArr = new HashSet[maxWordLen + 1];
        for (int i = 1; i < maxWordLen + 1; i++) {
            setArr[i] = new HashSet<String>();
        }
        for (String w : words) {
            setArr[w.length()].add(w);
        }

        StringBuilder path = new StringBuilder();
        recursive(setArr, path);

        return res;
    }

    public void recursive(HashSet[] setArr, StringBuilder path) {
        int curLen = path.length();
        if (curLen + 1 >= setArr.length) {
            return;
        }
        HashSet s = setArr[curLen + 1];

        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            path.append(ch);
            String tmp = path.toString();
            if (s.contains(tmp)) {
                if (tmp.length() > res.length()) {
                    res = tmp;
                } else if (tmp.length() == res.length() && tmp.compareTo(res) < 0) {
                    res = tmp;
                }
                recursive(setArr, path);
            }
            path.deleteCharAt(curLen);
        }
    }
}
