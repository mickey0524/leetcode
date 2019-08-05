# https://leetcode.com/problems/snapshot-array/
# Medium (28.55%)
# Total Accepted:    2,883
# Total Submissions: 10,098


class SnapshotArray:

    def __init__(self, length):
        self.d = collections.defaultdict(list)
        self.t = 0

    def set(self, index, val):
        if index not in self.d or self.t != self.d[index][-1][0]:
            # 如果是这个下标不存在，或者快照id大于最后一次修改的id，就新增版本
            self.d[index] += [[self.t, val]]
        else:
            self.d[index][-1][1] = val  # 同一层快照下面只用改值，不增加新版本

    def snap(self):
        self.t += 1
        return self.t - 1

    def get(self, index, snap_id):
        # 如果index存在，且查看id大于等于首次修改的id就继续
        if index in self.d and snap_id >= self.d[index][0][0]:
            ts = bisect.bisect(
                self.d[index], [snap_id, float('inf')])  # 二分查找右插入
            return self.d[index][ts - 1][1]  # 返回插入编号左边的版本的值
        return 0
