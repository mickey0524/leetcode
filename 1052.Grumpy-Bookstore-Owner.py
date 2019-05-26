# https://leetcode.com/problems/grumpy-bookstore-owner/
# Medium (46.84%)
# Total Accepted:    2,136
# Total Submissions: 4,560
# beats 100.0% of python submissions


class Solution(object):
    def maxSatisfied(self, customers, grumpy, X):
        """
        :type customers: List[int]
        :type grumpy: List[int]
        :type X: int
        :rtype: int
        """
        minutes = len(customers)
        if X == minutes:
            return sum(customers)

        res = 0
        for i in xrange(minutes):
            if grumpy[i] == 0:
                res += customers[i]

        cur = 0
        for i in xrange(X):
            if grumpy[i] == 1:
                cur += customers[i]

        tmp = cur
        for i in xrange(X, minutes):
            if grumpy[i] == 1:
                cur += customers[i]
            if grumpy[i - X] == 1:
                cur -= customers[i - X]
            tmp = max(tmp, cur)

        return tmp + res
