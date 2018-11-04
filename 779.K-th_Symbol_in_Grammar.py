# https://leetcode.com/problems/k-th-symbol-in-grammar/description/
#
# algorithms
# Medium (37.32%)
# Total Accepted:    7.8k
# Total Submissions: 20.9k
# beats 29.41% of python submissions


from collections import deque


class Solution(object):
    def kthGrammar(self, N, K):
        """
        :type N: int
        :type K: int
        :rtype: int
        """
        idx = K
        queue = deque()

        while idx != 1:
            last_idx = (idx + 1) / 2
            if last_idx * 2 == idx:
                queue.appendleft(1)
            else:
                queue.appendleft(0)

            idx = last_idx

        cnt_bit = '0'

        for idx in queue:
            s = '01' if cnt_bit == '0' else '10'
            cnt_bit = s[idx]

        return int(cnt_bit)
