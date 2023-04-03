// https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
// algorithms
// Easy (52.15%)
// Total Accepted: 17K
// Total Submissions: 32.6K

class Solution {

    public int minNumber(int[] nums1, int[] nums2) {
        int minNum1 = 11, minNum2 = 11;
        int allExistNum = Integer.MAX_VALUE;
        Set<Integer> set1 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
            minNum1 = Math.min(minNum1, n);
        }

        for (int n : nums2) {
            if (set1.contains(n)) {
                allExistNum = Math.min(allExistNum, n);
            }

            minNum2 = Math.min(minNum2, n);
        }

        return Math.min(allExistNum, minNum1 > minNum2 ? minNum2 * 10 + minNum1 : minNum1 * 10 + minNum2);
    }

}