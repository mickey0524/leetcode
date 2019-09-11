# https://leetcode.com/problems/expressive-words/
#
# algorithms
# Medium (44.51%)
# Total Accepted:    17,151
# Total Submissions: 38,530


class Solution(object):
    def expressiveWords(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        s_group = self.get_char_group(S)
        len_s_group = len(s_group)
        res = 0

        for w in words:
            w_group = self.get_char_group(w)
            if len(w_group) != len_s_group:
                continue

            can_spread = True
            for i in xrange(len_s_group):
                if w_group[i][0] != s_group[i][0]:
                    can_spread = False
                    break

                if w_group[i][1] > s_group[i][1]:
                    can_spread = False
                    break

                if s_group[i][1] < 3 and s_group[i][1] != w_group[i][1]:
                    can_spread = False
                    break

            if can_spread:
                res += 1

        return res

    def get_char_group(self, s):
        length = len(s)
        if length == 0:
            return []

        pre_idx = 0
        res = []

        for i in xrange(1, length + 1):
            if i == length or s[i] != s[pre_idx]:
                res.append((s[pre_idx], i - pre_idx))
                pre_idx = i

        return res
