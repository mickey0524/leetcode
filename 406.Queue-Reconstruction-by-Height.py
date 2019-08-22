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
        for idx, p in enumerate(people):
            hash_map[p[0]] += (p[1], idx),

        heights = hash_map.keys()
        res = []

        for h in reversed(sorted(heights)):
            arr = hash_map[h]
            arr.sort()

            for item in arr:
                res.insert(item[0], people[item[1]])

        return res
