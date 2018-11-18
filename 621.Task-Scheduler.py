# https://leetcode.com/problems/task-scheduler/description/
#
# algorithms
# Medium (43.1%)
# Total Accepted:    58.1k
# Total Submissions: 134.8k


from collections import Counter


class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        length = len(tasks)

        if n == 0 or length == 1:
            return length

        counter = Counter(tasks)
        values = list(counter.itervalues())
        values.sort(reverse=True)
        res, last = 0, 0

        while True:
            interval = n + 1
            for idx, v in enumerate(values):
                if v > 0:
                    values[idx] -= 1
                    interval -= 1
                    if interval == 0:
                        break
            if interval == n + 1:
                break
            last = interval
            res += (n + 1)
            values.sort(reverse=True)

        if last > 0:
            res -= last

        return res
