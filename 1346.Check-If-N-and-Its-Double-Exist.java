// https://leetcode.com/problems/check-if-n-and-its-double-exist/
// algorithms
// Easy (42.22%)
// Total Accepted: 6,319
// Total Submissions: 14,967
// beats 100.0% of java submissions


class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            if ((n % 2) == 0) {
                int tmp = n / 2;
                if (set.contains(tmp)) {
                    return true;
                }
            }

            if (set.contains(n * 2)) {
                return true;
            }

            set.add(n);
        }

        return false;
    }
}