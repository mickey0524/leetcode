// https://leetcode.com/problems/print-words-vertically/
// algorithms
// Medium (59.12%)
// Total Accepted: 5,607
// Total Submissions: 9,484
// beats 100.0% of java submissions


class Solution {

    public List<String> printVertically(String s) {
        ArrayList<String> res = new ArrayList<>();
        String[] arr = s.split(" ");

        int maxLen = Integer.MIN_VALUE;
        int arrLen = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i].length();
            if (tmp >= maxLen) {
                maxLen = tmp;
            }
        }
        char[][] matrix = new char[maxLen][arrLen];
        paddingMatrix(matrix, arr);

        for (char[] chs : matrix) {
            int idx;
            for (idx = arrLen - 1; idx >= 0; idx--) {
                if (chs[idx] != ' ') {
                    break;
                }
            }

            String tmp = new String(chs, 0, idx + 1);
            res.add(tmp);
        }

        return res;
    }

    private void paddingMatrix(char[][] matrix, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int rowIdx = 0;
            for (char ch : arr[i].toCharArray()) {
                matrix[rowIdx++][i] = ch;
            }
            for (; rowIdx < matrix.length; rowIdx++) {
                matrix[rowIdx][i] = ' ';
            }
        }
    }

}