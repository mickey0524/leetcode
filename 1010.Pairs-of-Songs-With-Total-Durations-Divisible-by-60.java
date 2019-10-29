// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//
// algorithms
// Easy (46.5%)
// Total Accepted: 19,986
// Total Submissions: 42,980



class Solution {

    static final int HOUR_SECOND = 60;

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            int tmp = t % HOUR_SECOND;
            if (tmp == 0) {
                res += map.getOrDefault(0, 0);
            } else {
                res += map.getOrDefault(HOUR_SECOND - tmp, 0);
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        return res;
    }
}