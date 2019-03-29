# https://leetcode.com/problems/candy/
#
# algorithms
# Medium (27.94%)
# Total Accepted:    98,701
# Total Submissions: 353,262


class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        length = len(ratings)
        if length < 2:
            return length

        candies = [1] * length

        for i in xrange(1, length):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        for i in xrange(length - 2, -1, -1):
            if ratings[i] > ratings[i + 1] and candies[i] <= candies[i + 1]:
                candies[i] = candies[i + 1] + 1

        return sum(candies)
