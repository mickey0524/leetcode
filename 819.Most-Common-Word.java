// https://leetcode.com/problems/most-common-word/
//
// algorithms
// Easy (42.74%)
// Total Accepted: 81,987
// Total Submissions: 191,812
// beats 100.0% of java submissions


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedMap = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> wordMap = new HashMap<>();

        int len = paragraph.length();
        int idx = 0;
        char[] chs = paragraph.toCharArray();

        while (idx < len) {
            if (!isAlpha(chs[idx])) {
                idx++;
            } else {
                int pre = idx;
                idx++;
                while (idx < len && isAlpha(chs[idx])) {
                    idx++;
                }

                String key = new String(chs, pre, idx - pre).toLowerCase();
                if (!bannedMap.contains(key)) {
                    wordMap.put(key, wordMap.getOrDefault(key, 0) + 1);
                }
            }
        }

        int curMax = Integer.MIN_VALUE;
        String res = null;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int value = entry.getValue();
            if (value > curMax) {
                curMax = value;
                res = entry.getKey();
            }
        }

        return res;
    }

    public boolean isAlpha(char ch) {
        int tmp = ch - 'a';
        if (tmp >= 0 && tmp < 26) {
            return true;
        }
        tmp = ch - 'A';
        if (tmp >= 0 && tmp < 26) {
            return true;
        }

        return false;
    }

}