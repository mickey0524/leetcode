# https://leetcode.com/problems/sliding-window-maximum/
#
# algorithms
# Hard (37.06%)
# Total Accepted:    137,871
# Total Submissions: 372,038
# beats 79.21% of python submissions

from collections import deque


class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        queue = deque()

        for i in xrange(k):
            length = len(queue)
            while length > 0:
                if nums[i] >= nums[queue[-1]]:
                    queue.pop()
                    length -= 1
                else:
                    break
            queue.append(i)

        res = []

        for i in xrange(k, len(nums)):
            res += nums[queue[0]],

            if i - queue[0] + 1 > k:
                queue.popleft()

            length = len(queue)
            while length > 0:
                if nums[i] >= nums[queue[-1]]:
                    queue.pop()
                    length -= 1
                else:
                    break

            queue.append(i)

        if len(queue) > 0:
            res += nums[queue[0]],

        return res
