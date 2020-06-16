// https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
// algorithms
// Easy (41.8%)
// Total Accepted: 18,020
// Total Submissions: 43,110


class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");

        reverse(arr);

        return String.join(" ", arr);
    }

    private void reverse(String[] arr) {
        int len = arr.length;
        int l = 0, r = len - 1;

        while (l < r) {
            swap(arr, l++, r--);
        }

        return;
    }

    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}