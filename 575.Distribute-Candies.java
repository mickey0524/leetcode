// https://leetcode.com/problems/distribute-candies/
//
// algorithms
// Easy (58.72%)
// Total Accepted: 62,276
// Total Submissions: 106,059


class Solution {
    public int distributeCandies(int[] candies) {
        int len = candies.length;
        HashSet<Integer> set = new HashSet<>();

        for (int c : candies) {
            set.add(c);
        }

        return Math.min(set.size(), len >>> 1);
    }
}