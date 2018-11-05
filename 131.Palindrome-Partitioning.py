# https://leetcode.com/problems/palindrome-partitioning/description/
#
# algorithms
# Medium (37.96%)
# Total Accepted:    138.9k
# Total Submissions: 365.9k
# beats 55.81% of python submissions

import copy

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = [[]]
        length = len(s)
        if length == 0:
            return [[]]

        def resursive(path, arr, idx, length):
            if idx == length:
                if path != path[::-1]:
                    return
                copy_arr = copy.copy(arr)
                if path:
                    copy_arr += path,
                res[0] += copy_arr,
                return

            if not path:
                resursive(s[idx], arr, idx + 1, length)
                return

            if path == path[::-1]:
                arr += path,
                resursive(s[idx], arr, idx + 1, length),
                arr.pop()

            resursive(path + s[idx], arr, idx + 1, length)

        resursive('', [], 0, length)

        return res[0]
