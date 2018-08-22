# https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
#
# algorithms
# Easy (61.3%)
# Total Accepted:    6.4k
# Total Submissions: 10.5k
# beats 61.03% of python submissions


from collections import Counter


class Solution(object):
    def uncommonFromSentences(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: List[str]
        """

        counter_a = Counter(A.split(' '))
        counter_b = Counter(B.split(' '))
        res = []

        for k, v in counter_a.iteritems():
            if counter_b.has_key(k):
                counter_b.pop(k)
            elif v == 1:
                res += k,

        for k, v in counter_b.items():
            if v > 1:
                counter_b.pop(k)

        res.extend(list(counter_b.iterkeys()))

        return res
