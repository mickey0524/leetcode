# https://leetcode.com/problems/permutation-in-string/description/
#
# algorithms
# Easy (36.65%)
# Total Accepted:    28.7k
# Total Submissions: 78.3k
# beats 40.28% of python submissions


from collections import Counter


class Solution(object):
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        def compare_counters(c1, c2):
            if len(c1) != len(c2):
                return False

            for k, v in c1.iteritems():
                if k not in c2 or c2.get(k) != v:
                    return False

            return True

        len_s1, len_s2 = len(s1), len(s2)

        if len_s1 > len_s2:
            return False

        counter_s1 = Counter(s1)
        counter_s2 = Counter(s2[:len_s1])

        if compare_counters(counter_s1, counter_s2):
            return True

        for i in xrange(len_s1, len_s2):
            head_k = s2[i - len_s1]
            head_v = counter_s2.get(head_k)
            head_v -= 1
            if head_v == 0:
                del counter_s2[head_k]
            else:
                counter_s2[head_k] = head_v
            tail_k = s2[i]
            tail_v = counter_s2.get(tail_k, 0)
            counter_s2[tail_k] = tail_v + 1
            if compare_counters(counter_s1, counter_s2):
                return True

        return False
