// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
// algorithms
// Easy (74.12%)
// Total Accepted: 6.3K
// Total Submissions: 8.5K


class Solution {
    public int minTimeToType(String word) {
        int pos = 0;
        int res = 0;
        
        for (char ch : word.toCharArray()) {
            int move = moveStep(pos, ch - 'a');
            res += move + 1;
            
            pos = ch - 'a';
        }
        
        return res;
    }
    
    private int moveStep(int cur, int target) {
        if (cur == target) {
            return 0;
        }
        
        int clockwise = target > cur ? target - cur : 26 - cur + target;
        int antiClockwise = target < cur ? cur - target : cur + 26 - target;
        
        return Math.min(clockwise, antiClockwise);
    }
}