// https://leetcode.com/problems/count-pairs-of-similar-strings/description/
// algorithms
// Easy (65.3%)
// Total Accepted: 9.8K
// Total Submissions: 15K


class Solution {

    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String w : words) {
            int binaryExpression = genBinaryExpression(w);
            map.put(binaryExpression, map.getOrDefault(binaryExpression, 0) + 1);
        }

        int res = 0;
        for (int v : map.values()) {
            if (v > 1) {
                res += v * (v - 1) / 2;
            }
        }

        return res;
    }

    private int genBinaryExpression(String w) {
        int binaryExpression = 0;
        
        for (char ch : w.toCharArray()) {
            binaryExpression |= (1 << (ch - 'a'));
        }

        return binaryExpression;
    }

}
