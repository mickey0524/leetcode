# https://leetcode.com/problems/arithmetic-slices/
#
# algorithms
# Medium (60.64%)
# Total Accepted:    87,034
# Total Submissions: 143,526


from collections import defaultdict


class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        hash_map = defaultdict(list)
        for h, k in people:
            hash_map[h].append(k)

        keys = hash_map.keys()
        res = []

        for h in reversed(sorted(keys)):
            arr = hash_map[h]
            arr.sort()

            for n in arr:
                res.insert(n, [h, n])

        return res
