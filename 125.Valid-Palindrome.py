# https://leetcode.com/problems/valid-palindrome/
#
# algorithms
# Easy (30.75%)
# Total Accepted:    341,766
# Total Submissions: 1,111,478


class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        length = len(s)

        l, r = 0, length - 1
        while l < r:
            while l < r and not self.is_valid(s[l]):
                l += 1
            while l < r and not self.is_valid(s[r]):
                r -= 1
            if l == r:
                return True

            if s[l] != s[r]:
                return False
            l += 1
            r -= 1

        return True

    def is_valid(self, ch):
        ascii = ord(ch)
        if 48 <= ascii <= 57 or 97 <= ascii <= 122:
            return True

        return False
