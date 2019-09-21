# https://leetcode.com/problems/count-of-smaller-numbers-after-self/
#
# algorithms
# Hard (39.35%)
# Total Accepted:    88,802
# Total Submissions: 225,695


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        if length == 0:
            return []

        origin_idx = [i for i in xrange(length)]  # 存储当前这个位置元素在原始数组中的位置
        more = [0] * length

        def merge_sort(start, end):
            if start >= end:
                return

            middle = start + (end - start) / 2
            merge_sort(start, middle)
            merge_sort(middle + 1, end)

            tmp = []
            origin_tmp = []
            l_idx, r_idx = start, middle + 1
            while l_idx <= middle and r_idx <= end:
                if nums[l_idx] > nums[r_idx]:
                    tmp.append(nums[l_idx])
                    more[origin_idx[l_idx]] += (end - r_idx + 1)
                    origin_tmp.append(origin_idx[l_idx])
                    l_idx += 1
                else:
                    tmp.append(nums[r_idx])
                    origin_tmp.append(origin_idx[r_idx])
                    r_idx += 1

            if l_idx <= middle:
                tmp += nums[l_idx:middle + 1]
                origin_tmp += origin_idx[l_idx:middle + 1]
            if r_idx <= end:
                tmp += nums[r_idx:end + 1]
                origin_tmp += origin_idx[r_idx:end + 1]

            for i in xrange(start, end + 1):
                nums[i] = tmp[i - start]
                origin_idx[i] = origin_tmp[i - start]

        merge_sort(0, length - 1)

        return more
