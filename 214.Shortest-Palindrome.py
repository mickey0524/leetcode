# https://leetcode.com/problems/shortest-palindrome/description/
#
# algorithms
# Hard (26.25%)
# Total Accepted:    63.7k
# Total Submissions: 242.7k
# beats 40.0% of python submissions


class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)
        if length < 2:
            return s

        reverse_s = s[::-1]

        for i in xrange(length):
            if s.startswith(reverse_s[i:]):
                return reverse_s[:i] + s

        return s

# 比较好的做法
# 思想还是去找最左最长的回文串，通过遍历得到当次匹配的元素个数，然后缩小范围，再次遍历（回文串不可能比这个还长，只能更短）

class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        j, end = 0, len(s)
        while True:
            j = 0
            for i in range(end - 1, -1, -1):
                if s[i] == s[j]:
                    j += 1
            if j == end:
                break
            end = j
        return s[end:][::-1] + s[:end] + s[end:]
