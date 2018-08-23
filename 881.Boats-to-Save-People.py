# https://leetcode.com/problems/boats-to-save-people/description/
#
# algorithms
# Medium (38.8%)
# Total Accepted:    4.7k
# Total Submissions: 12.2k
# beats 88.76% of python submissions


class Solution(object):
    def numRescueBoats(self, people, limit):
        """
        :type people: List[int]
        :type limit: int
        :rtype: int
        """
        head, tail = 0, len(people) - 1
        people.sort(reverse=True)
        res = 0

        while head <= tail:
            if people[head] + people[tail] <= limit:
                tail -= 1
            head += 1
            res += 1

        return res
