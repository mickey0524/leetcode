// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
// algorithms
// Medium (91.75%)
// Total Accepted: 7,226
// Total Submissions: 7,876
// beats 100.0% of java submissions


class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int maxCandyNum = Integer.MIN_VALUE;
        for (int c : candies) {
            if (c > maxCandyNum) {
                maxCandyNum = c;
            }
        }

        List<Boolean> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= maxCandyNum) {
                res.add(Boolean.TRUE);
            } else {
                res.add(Boolean.FALSE);
            }
        }

        return res;
    }
}