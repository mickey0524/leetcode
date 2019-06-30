# https://leetcode.com/problems/distribute-candies-to-people/
# Easy (60.86%)
# Total Accepted:    2,620
# Total Submissions: 4,305
# beats 100.0% of python submissions


class Solution(object):
    def distributeCandies(self, candies, num_people):
        """
        :type candies: int
        :type num_people: int
        :rtype: List[int]
        """
        res = [0] * num_people
        l, r = 1, num_people

        while candies > 0:
            cost = (l + r) * num_people / 2
            if candies >= cost:
                for i in xrange(num_people):
                    res[i] += (l + i)
                candies -= cost
                l, r = l + num_people, r + num_people
            else:
                for i in xrange(num_people):
                    delta = min(candies, l)
                    res[i] += delta
                    l += 1
                    candies -= delta

                    if candies == 0:
                        break

        return res
