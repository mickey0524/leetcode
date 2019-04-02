# https://leetcode.com/problems/knight-dialer/
#
# algorithms
# Medium (39.01%)
# Total Accepted:    8,384
# Total Submissions: 21,491


class Solution(object):
    def knightDialer(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N == 1:
            return 10

        BASE = 10 ** 9 + 7

        hop_arr = [[4, 6], [6, 8], [7, 9], [4, 8], [
            0, 3, 9], [], [0, 1, 7], [2, 6], [1, 3], [2, 4]]
        next_pad = [0] * 10
        for row in hop_arr:
            for n in row:
                next_pad[n] += 1

        for _ in xrange(2, N):
            tmp = [0] * 10
            for idx, n in enumerate(next_pad):
                for to in hop_arr[idx]:
                    tmp[to] += n
            next_pad = [n % BASE for n in tmp]

        return int(sum(next_pad) % BASE)
