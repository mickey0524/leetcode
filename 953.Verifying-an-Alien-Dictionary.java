// https://leetcode.com/problems/verifying-an-alien-dictionary/
//
// algorithms
// Easy (55.63%)
// Total Accepted:    41,979
// Total Submissions: 75,461
// beats 100.0% of java submissions


class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>(order.length());
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!compare(map, words[i - 1], words[i])) {
                return false;
            }
        }
        
        return true;
    }

    private boolean compare(HashMap<Character, Integer> map, String pre, String cur) {
        if (pre.equals(cur)) {
            return true;
        }

        int preLen = pre.length(), curLen = cur.length();
        for (int i = 0; i < Math.min(preLen, curLen); i++) {
            int curVal = map.get(cur.charAt(i));
            int preVal = map.get(pre.charAt(i));
            if (curVal < preVal) {
                return false;
            } else if (curVal > preVal) {
                return true;
            }
        }
        
        if (curLen > preLen) {
            return true;
        }
        
        return false;
    }
}