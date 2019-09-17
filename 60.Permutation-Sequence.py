# https://leetcode.com/problems/length-of-last-word/
#
# algorithms
# Medium (34.09%)
# Total Accepted:    150,040
# Total Submissions: 440,093


class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        tmp = self.helper([i for i in xrange(1, n + 1)], k)

        return ''.join(map(str, tmp))

    def helper(self, arr, k):
        if k == 1:
            return arr

        length = len(arr)
        tmp = self.get_factorial(length - 1)
        i = 0
        while (i + 1) * tmp < k:
            i += 1

        prefix = [arr[i]]

        return prefix + self.helper(arr[:i] + arr[i + 1:], k - tmp * i)

    def get_factorial(self, n):
        res = 1

        for i in xrange(1, n + 1):
            res *= i

        return res
