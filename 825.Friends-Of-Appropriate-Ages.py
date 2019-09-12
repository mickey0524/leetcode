# https://leetcode.com/problems/friends-of-appropriate-ages/
#
# algorithms
# Medium (37.93%)
# Total Accepted:    19,269
# Total Submissions: 50,797
# beats 88.28% of python submissions


from collections import defaultdict


class Solution(object):
    def numFriendRequests(self, ages):
        """
        :type ages: List[int]
        :rtype: int
        """
        hash_map = defaultdict(int)

        for n in ages:
            hash_map[n] += 1

        res = 0

        for i in xrange(1, 121):
            if i not in hash_map:
                continue

            lower = int(0.5 * i) + 7 + 1
            upper = i

            for j in xrange(lower, upper + 1):
                if j in hash_map:
                    if j == i:
                        res += hash_map[j] * (hash_map[j] - 1)

                    else:
                        res += hash_map[j] * hash_map[i]

        return res
