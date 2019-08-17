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


from heapq import heappush, heappop


class Solution1(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_num = [0] * 26

        for ch in tasks:
            idx = ord(ch) - 65
            task_num[idx] += 1

        h = []
        for num in task_num:
            if num != 0:
                heappush(h, -num)

        res = 0
        while h:
            tmp = []
            i = 0

            while i < n + 1:
                if not h:
                    break

                num = heappop(h)
                if num < -1:
                    tmp.append(num + 1)

                i += 1

            if tmp:
                res += (n + 1)
                for num in tmp:
                    heappush(h, num)

            else:
                res += i

        return res
