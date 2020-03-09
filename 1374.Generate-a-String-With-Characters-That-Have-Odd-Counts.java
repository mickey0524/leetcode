// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
// algorithms
// Easy (77.23%)
// Total Accepted: 9,083
// Total Submissions: 11,761
// beats 100.0% of java submissions


class Solution {
    public String generateTheString(int n) {
        char[] arr = arr = new char[n];
        Arrays.fill(arr, 'a');
        if ((n & 1) == 0) {
            arr[0] = 'b';
        }

        return new String(arr);
    }
}