// https://leetcode.com/problems/roman-to-integer/
//
// algorithms
// Easy (52.45%)
// Total Accepted: 421,751
// Total Submissions: 804,113
// beats 66.39% of java submissions

class Solution {
    public int romanToInt(String s) {
        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 7; i++) {
            map.put(symbols[i], i);
        }
        
        int len = s.length();
        int idx = 0, res = 0;
        
        while (idx < len) {
            if (idx < len - 1) {
                int nowSymbolIdx = map.get(s.charAt(idx));
                int nextSymbolIdx = map.get(s.charAt(idx + 1));
                if (nowSymbolIdx >= nextSymbolIdx) {
                    res += values[nowSymbolIdx];
                    idx++;
                } else {
                    res += (values[nextSymbolIdx] - values[nowSymbolIdx]);
                    idx += 2;
                }
            } else {
                res += values[map.get(s.charAt(idx))];
                idx++;
            }
        }
        
        return res;
    }
}