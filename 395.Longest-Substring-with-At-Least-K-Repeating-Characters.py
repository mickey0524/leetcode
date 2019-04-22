# https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
#
# algorithms
# Medium (38.36%)
# Total Accepted:    44,940
# Total Submissions: 117,151


from collections import defaultdict


class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        hash_map = defaultdict(int)
        for ch in s:
            hash_map[ch] += 1

        not_match_chs = set()
        for key, v in hash_map.iteritems():
            if v < k:
                not_match_chs.add(key)

        if not not_match_chs:
            return len(s)

        l = 0
        res = 0
        for idx, ch in enumerate(s):
            if ch in not_match_chs:
                res = max(res, self.longestSubstring(s[l:idx], k))
                l = idx + 1

        res = max(res, self.longestSubstring(s[l:], k))

        return res
