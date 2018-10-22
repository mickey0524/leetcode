# https://leetcode.com/problems/4sum/description/
#
# algorithms
# Medium (28.5%)
# Total Accepted:    185K
# Total Submissions: 648.9M
# beats 60.22% of python submissions
# 这道题的我的思路将4个数相加转化为两个数的和与两个树的和的相加
# 首先用一个dict记录所有可能的和以及进行相加的两个数的下标
# 然后进行遍历，这里需要进行过滤，因为两个和可能使用了相同的数
# 这层过滤之后还需要进行下一层的过滤，因为使用的数不能重复

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def is_repeat(x, y):
            arr = []
            arr.extend(x)
            arr.extend(y)
            if len(set(arr)) == 4:
                tmp = map(lambda i: nums[i], arr)
                tmp.sort()
                exist_k = ','.join(map(lambda i: str(i), tmp))
                if exist_k not in s:
                    s[exist_k] = True
                    return tmp

            return False

        length = len(nums)
        hash_map = {}

        for i in xrange(length):
            for j in xrange(i + 1, length):
                if i == j:
                    continue
                s = nums[i] + nums[j]
                cnt_arr = hash_map.get(s, [])
                cnt_arr += (i, j),
                hash_map[s] = cnt_arr

        res, s = [], {}

        for k, values in hash_map.iteritems():
            if values == False:
                continue

            match_k = target - k
            if match_k == k:
                len_v = len(values)
                for i in xrange(len_v):
                    for j in xrange(i + 1, len_v):
                        r = is_repeat(values[i], values[j])
                        if r:
                            res += r,

            elif match_k in hash_map and hash_map[match_k] != False:
                match_values = hash_map[match_k]
                for v in values:
                    for t in match_values:
                        r = is_repeat(v, t)
                        if r:
                            res += r,
                hash_map[match_k] = False

            hash_map[k] = False

        return res
