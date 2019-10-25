// https://leetcode.com/problems/positions-of-large-groups/
//
// algorithms
// Easy (48.27%)
// Total Accepted: 32,494
// Total Submissions: 67,316
// beats 100.0% of java submissions


class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();

        int len = S.length();
        if (len < 3) {
            return res;
        }

        char[] chs = S.toCharArray();
        int preIdx = 0;
        for (int i = 1; i <= len; i++) {
            if (i == len || chs[i] != chs[i - 1]) {
                if (i - preIdx >= 3) {
                    res.add(Arrays.asList(preIdx, i - 1));
                }

                preIdx = i;
            }
        }

        return res;
    }
}