// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
// algorithms
// Medium (57.43%)
// Total Accepted: 11,132
// Total Submissions: 19,384


class Solution {
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length;
        for (int i = 0; i < len; i++) {
            if (capacity[i] > rocks[i]) {
                capacity[i] -= rocks[i];
            } else {
                capacity[i] = 0;
            }
        }
        
        int res = 0;
        Arrays.sort(capacity);
        for (int i = 0; i < len; i++) {
            if (capacity[i] == 0) {
                res++;
            } else if (additionalRocks >= capacity[i]) {
                res++;
                additionalRocks -= capacity[i];
            } else {
                break;
            }
        }
        
        return res;
    }
    
}