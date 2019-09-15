// https://leetcode.com/problems/maximum-number-of-balloons/
//
// algorithms
// Easy (62.25%)
// Total Accepted: 3,652
// Total Submissions: 5,867
// beats 100.0% of java submissions


class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int res = Integer.MAX_VALUE;
        
        res = Math.min(res, map.getOrDefault('b', 0));
        res = Math.min(res, map.getOrDefault('a', 0));
        res = Math.min(res, map.getOrDefault('n', 0));
        res = Math.min(res, map.getOrDefault('l', 0) / 2);
        res = Math.min(res, map.getOrDefault('o', 0) / 2);
        
        return res;
    }
}