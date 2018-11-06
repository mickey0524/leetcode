# https://leetcode.com/problems/interleaving-string/description/
#
# algorithms
# Hard (26.32%)
# Total Accepted:    95.3k
# Total Submissions: 362k
# beats 100.0% of python submissions
# DFS，精髓是用一个is_visited保存曾经遍历过的可能，避免无效循环


class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        len_s1, len_s2, len_s3 = len(s1), len(s2), len(s3)

        if len_s3 != len_s1 + len_s2:
            return False

        is_visited = {}

        def resursive(i, j, k):
            if i == len_s1:
                return s2[j:] == s3[k:]
            if j == len_s2:
                return s1[i:] == s3[k:]
            if (i, j) in is_visited:
                return is_visited[(i, j)]

            res = False

            if s1[i] == s3[k]:
                res |= resursive(i + 1, j, k + 1)
            if s2[j] == s3[k]:
                res |= resursive(i, j + 1, k + 1)

            is_visited[(i, j)] = res

            return res

        return resursive(0, 0, 0)
