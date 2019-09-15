# https://leetcode.com/problems/fruit-into-baskets/
#
# algorithms
# Medium (41.81%)
# Total Accepted:    64,273
# Total Submissions: 153,719
# beats 72.87% of python submissions


class Solution(object):
    def totalFruit(self, tree):
        """
        :type tree: List[int]
        :rtype: int
        """
        length = len(tree)
        if length < 3:
            return length

        l, r, res = 0, 0, 1
        hash_map = {}
        while r < length:
            if tree[r] in hash_map:
                hash_map[tree[r]] += 1

            elif len(hash_map) < 2:
                hash_map[tree[r]] = 1

            else:
                res = max(res, r - l)
                while len(hash_map) == 2:
                    if hash_map[tree[l]] == 1:
                        del hash_map[tree[l]]
                    else:
                        hash_map[tree[l]] -= 1
                    l += 1

                hash_map[tree[r]] = 1

            r += 1

        return max(res, r - l)
