// https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
// algorithms
// Easy (73.26%)
// Total Accepted: 6,579
// Total Submissions: 8,980


class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = lowLimit; i <= highLimit; i++) {
            int k = getBitSum(i);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int res = 0;
        for (int v : map.values()) {
            res = Math.max(res, v);
        }
        
        return res;
    }
    
    private int getBitSum(int n) {
        String tmp = String.valueOf(n);
        int res = 0;
        
        for (char ch : tmp.toCharArray()) {
            res += (ch - '0');
        }
        
        return res;
    }
    
}