# https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
# Medium (62.89%)
# Total Accepted:    1,717
# Total Submissions: 2,730
# beats 100.0% of python submissions


from collections import deque


class Solution(object):
    def queryString(self, S, N):
        """
        :type S: str
        :type N: int
        :rtype: bool
        """
        length = len(S)
        init_one_idx = S.find('1')

        if init_one_idx == -1:
            return False

        q = deque([('1', 1, init_one_idx)])

        while len(q) > 0:
            cur = q.popleft()
            a = cur[1] * 2
            b = a + 1
            if a > N:
                return True

            if cur[2] == length - 1:
                return False

            if b <= N:
                if S[cur[2] + 1] == '0':
                    q.append((cur[0] + '0', a, cur[2] + 1))
                    next_idx = S.find(cur[0] + '1', cur[2] - len(cur[0]) + 1)
                    if next_idx == -1:
                        return False
                    else:
                        q.append((cur[0] + '1', b, next_idx + len(cur[0])))
                else:
                    next_idx = S.find(cur[0] + '0', cur[2] - len(cur[0]) + 1)
                    if next_idx == -1:
                        return False
                    else:
                        q.append((cur[0] + '0', a, next_idx + len(cur[0])))
                    q.append((cur[0] + '1', b, cur[2] + 1))

            else:
                if S[cur[2] + 1] == '0':
                    return True
                return True if S.find(cur[0] + '0', cur[2] - len(cur[0])) != -1 else False

        return False
