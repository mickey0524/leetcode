# https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
# Medium (45.68%)
# Total Accepted:    3,192
# Total Submissions: 6,988


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeZeroSumSublists(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        nums = []
        hash_map = {0: 0}
        val_sum = 0
        idx = 0
        intervals = []
        tmp = head

        while head:
            nums.append(head.val)
            val_sum += head.val
            idx += 1

            if val_sum in hash_map:
                intervals.append((hash_map[val_sum], idx))

            hash_map[val_sum] = idx
            head = head.next

        if len(intervals) == 0:
            return tmp
        # print intervals
        intervals.sort()
        sum_zero_interval = []
        cur_l, cur_r = intervals[0]

        for i in xrange(1, len(intervals)):
            if intervals[i][0] == cur_l:
                cur_r = intervals[i][1]

            elif intervals[i][0] >= cur_r:
                sum_zero_interval.append((cur_l, cur_r))
                cur_l, cur_r = intervals[i]

        sum_zero_interval.append((cur_l, cur_r))

        res = nums[:sum_zero_interval[0][0]]

        for i in xrange(len(sum_zero_interval) - 1):
            res += nums[sum_zero_interval[i][1]:sum_zero_interval[i + 1][0]]

        res += nums[sum_zero_interval[-1][1]:]
        ans = ListNode(-1)
        tmp = ans

        for v in res:
            n = ListNode(v)
            ans.next = n
            ans = n

        return tmp.next
