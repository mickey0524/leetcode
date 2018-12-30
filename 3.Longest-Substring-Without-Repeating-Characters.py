# https://leetcode.com/problems/longest-substring-without-repeating-characters/
#
# algorithms
# Medium (25.7%)
# Total Accepted:    685,233
# Total Submissions: 2,668,623


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)

        if length < 2:
            return length

        hash_map = {}
        head, tail = 0, 0
        res = 0

        while tail < length:
            if hash_map.get(s[tail], -1) >= head:
                head = hash_map[s[tail]] + 1
            hash_map[s[tail]] = tail
            res = max(res, tail - head + 1)
            tail += 1

        return res
