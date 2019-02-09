# https://leetcode.com/problems/exam-room/
#
# algorithms
# Medium (36.69%)
# Total Accepted:    11,241
# Total Submissions: 30,636
# beats 67.77% of python submissions


class ExamRoom(object):

    def __init__(self, N):
        self.N, self.L = N, []

    def seat(self):
        N, L = self.N, self.L
        if not L:
            res = 0
        else:
            d, res = L[0], 0
            for a, b in zip(L, L[1:]):
                if (b - a) / 2 > d:
                    d, res = (b - a) / 2, (b + a) / 2
            if N - 1 - L[-1] > d:
                res = N - 1
        bisect.insort(L, res)
        return res

    def leave(self, p):
        self.L.remove(p)


# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(N)
# param_1 = obj.seat()
# obj.leave(p)
