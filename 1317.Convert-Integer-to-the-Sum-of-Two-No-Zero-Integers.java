// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
// algorithms
// Easy (57.89%)
// Total Accepted: 9,891
// Total Submissions: 17,085
// beats 100.0% of java submissions


class Solution {

    private static HashSet<Integer> set = new HashSet<>();

    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - 1;

        while (!isQualify(a, b)) {
            a++;
            b--;
        }

        return new int[] { a, b };
    }

    private boolean isQualify(int a, int b) {
        if (set.contains(a) || set.contains(b)) {
            return false;
        }

        if (containsZero(a)) {
            set.add(a);
            return false;
        }

        if (containsZero(b)) {
            set.add(b);
            return false;
        }

        return true;
    }

    private boolean containsZero(String s) {
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                return true;
            }
        }

        return false;
    }

    private boolean containsZero(int n) {
        return containsZero(String.valueOf(n));
    }
}