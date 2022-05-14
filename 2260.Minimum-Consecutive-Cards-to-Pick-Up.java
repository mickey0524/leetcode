// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
// algorithms
// Medium (54.04%)
// Total Accepted: 15,544
// Total Submissions: 28,764


class Solution {
    
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int len = cards.length;
        
        for (int i = 0; i < len; i++) {
            Integer preIdx = idxMap.get(cards[i]);
            if (preIdx != null) {
                res = Math.min(res, i - preIdx + 1);
            }
            
            idxMap.put(cards[i], i);
        }
        
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        
        return res;
    }
    
}