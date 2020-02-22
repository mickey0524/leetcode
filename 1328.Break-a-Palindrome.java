// https://leetcode.com/problems/break-a-palindrome/
// algorithms
// Medium (40.75%)
// Total Accepted: 4,582
// Total Submissions: 11,244
// beats 100.0% of java submissions


class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1) {
            return "";
        }

        char[] arr = palindrome.toCharArray();
        boolean resFound = false;

        for (int i = 0; i < len; i++) {
            if (arr[i] != 'a' && !((len & 1) == 1 && i == (len / 2))) {
                arr[i] = 'a';
                resFound = true;
                break;
            }
        }

        if (!resFound) {
            arr[len - 1] = 'b';
        }

        return new String(arr);
    }
}