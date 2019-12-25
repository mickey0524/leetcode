// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
// algorithms
// Medium (43.69%)
// Total Accepted: 3,663
// Total Submissions: 8,385


class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        char[] chs = s.toCharArray();
        int res = 0;

        for (int l = minSize; l <= maxSize; l++) {
            HashMap<String, Integer> map = new HashMap<>();
            int[] chFreq = new int[26];
            int chNum = 0;

            for (int i = 0; i <= len; i++) {
                if (i >= l) {
                    if (chNum <= maxLetters) {
                        String tmp = s.substring(i - l, i);
                        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                    }
                    if (i == len) {
                        break;
                    }

                }

                int idx = chs[i] - 'a';
                if (chFreq[idx] == 0) {
                    chNum++;
                }
                chFreq[idx]++;
                if (i >= l) {
                    idx = chs[i - l] - 'a';
                    if (chFreq[idx] == 1) {
                        chNum--;
                    }
                    chFreq[idx]--;
                }
            }

            for (int n : map.values()) {
                res = Math.max(res, n);
            }
        }

        return res;
    }
}