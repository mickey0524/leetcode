# https://leetcode.com/problems/find-and-replace-pattern/description/
#
# algorithms
# Medium (70.6%)
# Total Accepted:    5k
# Total Submissions: 7k


from collections import OrderedDict


class Solution(object):
    def findAndReplacePattern(self, words, pattern):
        """
        :type words: List[str]
        :type pattern: str
        :rtype: List[str]
        """
        def gen_dict(s):
            s_obj = OrderedDict()

            for idx, ch in enumerate(s):
                cnt_arr = s_obj.get(ch, [])
                cnt_arr += idx,
                s_obj[ch] = cnt_arr

            return s_obj

        res = []
        pattern_obj = gen_dict(pattern)

        for word in words:
            word_obj = gen_dict(word)
            if list(pattern_obj.itervalues()) == list(word_obj.itervalues()):
                res += word,

        return res
