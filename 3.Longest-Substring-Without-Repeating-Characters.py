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


# 二刷的时候速度更快的做法

class Solution1(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        res = float('-inf')
        hash_map = {}
        pre_idx = 0

        for idx in xrange(length):
            ch = s[idx]
            if ch in hash_map:
                res = max(res, idx - pre_idx)
                ch_pre_idx = hash_map[ch]

                for i in xrange(pre_idx, ch_pre_idx + 1):
                    if hash_map[s[i]] < ch_pre_idx:
                        del hash_map[s[i]]

                pre_idx = ch_pre_idx + 1

            hash_map[ch] = idx

        res = max(res, length - pre_idx)

        return res
