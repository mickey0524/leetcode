# https://leetcode.com/problems/combination-sum/
#
# algorithms
# Medium (49.33%)
# Total Accepted:    360,573
# Total Submissions: 730,990
# beats 100.0% of python submissions


class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = [[]]
        candidates.sort()
        length = len(candidates)

        def recursive(idx, cur_sum, path):
            if cur_sum == target:
                res[0] += path,
                return

            for i in xrange(idx, length):
                if candidates[i] + cur_sum > target:
                    break
                recursive(i, cur_sum + candidates[i], path + [candidates[i]])

        recursive(0, 0, [])

        return res[0]