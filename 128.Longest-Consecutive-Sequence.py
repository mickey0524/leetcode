# https://leetcode.com/problems/surrounded-regions/description/
#
# algorithms
# Hard (41.39%)
# Total Accepted:    201,349
# Total Submissions: 486,416


class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hash_map = {}
        res = 0

        for n in nums:
            if n in hash_map:
                continue
            arr = [0, 0]
            if n - 1 in hash_map:
                arr[0] = hash_map[n - 1][0] + 1
            if n + 1 in hash_map:
                arr[1] = hash_map[n + 1][1] + 1
            hash_map[n] = arr

            tmp = n - 1
            base = 1
            while tmp in hash_map:
                hash_map[tmp][1] = max(hash_map[tmp][1], arr[1] + base)
                tmp -= 1
                base += 1

            tmp = n + 1
            base = 1
            if tmp in hash_map:
                hash_map[tmp][0] = max(hash_map[tmp][0], arr[0] + base)
                tmp += 1
                base += 1

        for k, arr in hash_map.iteritems():
            res = max(res, 1 + arr[0] + arr[1])

        return res
