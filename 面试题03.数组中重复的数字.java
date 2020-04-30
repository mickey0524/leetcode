// https://leetcode-cn.com/problems/animal-shelter-lcci/
// algorithms
// Easy (67.03%)
// Total Accepted: 42,168
// Total Submissions: 62,905


class Solution {

    private static final int DEFAULT_RES = -1;

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }

            set.add(n);
        }

        return DEFAULT_RES;
    }
}