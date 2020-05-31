// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
// algorithms
// Easy (87.32%)
// Total Accepted: 6,591
// Total Submissions: 7,548
// beats 100.0% of java submissions


class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] numArr = new int[1001];
        int len = target.length;

        for (int i = 0; i < len; i++) {
            numArr[target[i]]++;
            numArr[arr[i]]--;
        }

        for (int n : numArr) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}