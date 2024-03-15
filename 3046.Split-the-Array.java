// https://leetcode.com/problems/split-the-array/description/
// algorithms
// Easy (56.7%)
// Total Accepted: 35.5K
// Total Submissions: 62.7K


class Solution {

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            Integer curTime = map.get(n);
            if (curTime == null) {
                map.put(n, 1);
            } else if (curTime >= 2) {
                return false;
            } else {
                map.put(n, curTime + 1);
            }
        }

        return true;
    }

}