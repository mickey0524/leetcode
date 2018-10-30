# https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
#
# algorithms
# Medium (52.03%)
# Total Accepted:    14.1k
# Total Submissions: 27.1k
# beats 44.63% of python submissions


class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        s1_ascii_sum, s2_ascii_sum = 0, 0
        for ch in s1:
            s1_ascii_sum += ord(ch)
        for ch in s2:
            s2_ascii_sum += ord(ch)

        s1_len, s2_len = len(s1), len(s2)
        max_common_subseq = [[0] * (s2_len + 1) for _ in xrange(s1_len + 1)]
        max_common_sum = 0

        for i in xrange(1, s1_len + 1):
            for j in xrange(1, s2_len + 1):
                if s1[i - 1] == s2[j - 1]:
                    max_common_subseq[i][j] = ord(
                        s1[i - 1]) + max_common_subseq[i - 1][j - 1]
                else:
                    max_common_subseq[i][j] = max(
                        max_common_subseq[i - 1][j], max_common_subseq[i][j - 1])

                max_common_sum = max(max_common_sum, max_common_subseq[i][j])

        return s1_ascii_sum + s2_ascii_sum - max_common_sum * 2
