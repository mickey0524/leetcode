// https://leetcode.com/problems/generate-parentheses/
//
// algorithms
// Medium (54.86%)
// Total Accepted: 337,678
// Total Submissions: 615,535
// beats 100.0% of java submissions


class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        char[] chArr = new char[2 * n];

        recursive(res, n, n, chArr, 0);

        return res;
    }

    public void recursive(ArrayList<String> res, int left, int right, char[] chArr, int idx) {
        if (left == 0 && right == 0) {
            res.add(new String(chArr));
            return;
        }

        if (right > left) {
            chArr[idx] = ')';
            recursive(res, left, right - 1, chArr, idx + 1);
        }

        if (left > 0) {
            chArr[idx] = '(';
            recursive(res, left - 1, right, chArr, idx + 1);
        }
    }
}