// https://leetcode.com/problems/simplified-fractions/
// algorithms
// Medium (59.89%)
// Total Accepted: 7,633
// Total Submissions: 12,746
// beats 100.0% of java submissions


class Solution {

    private static final char SEPARATOR = '/';

    public List<String> simplifiedFractions(int n) {
        List<String> res = new LinkedList<>();

        for (int i = 2; i <= n; i++) {
            res.add(buildFraction(1, i));
            for (int j = 2; j < i; j++) {
                if (!isReducible(j, i)) {
                    res.add(buildFraction(j, i));
                }
            }
        }

        return res;
    }

    private String buildFraction(int top, int bottom) {
        StringBuilder sb = new StringBuilder();
        sb.append(top).append(SEPARATOR).append(bottom);

        return sb.toString();
    }

    private boolean isReducible(int top, int bottom) {
        if (bottom % top == 0) {
            return true;
        }

        for (int i = 2; i < top; i++) {
            if ((top % i == 0) && (bottom % i == 0)) {
                return true;
            }
        }

        return false;
    }
}