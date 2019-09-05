# https://leetcode.com/problems/lfu-cache/
#
# algorithms
# Hard (29.8%)
# Total Accepted:    45,876
# Total Submissions: 153,943


class Heap(object):

    def __init__(self):
        self.h = []

    def __len__(self):
        return len(self.h)

    def _up(self, idx):
        while idx > 0:
            parent_idx = (idx - 1) / 2
            if parent_idx < 0:
                break

            if self.h[idx].freq < self.h[parent_idx].freq or (
                    self.h[idx].freq == self.h[parent_idx].freq and self.h[idx].ts < self.h[parent_idx].ts):
                self.h[idx], self.h[parent_idx] = self.h[parent_idx], self.h[idx]
                self.h[idx].idx, self.h[parent_idx].idx = idx, parent_idx
                idx = parent_idx

            else:
                break

    def _down(self, idx):
        bound = len(self.h)

        while idx < bound:
            left_child_idx = 2 * idx + 1
            if left_child_idx >= bound:
                break
            min_child_idx = left_child_idx

            right_child_idx = left_child_idx + 1
            if right_child_idx < bound and (self.h[right_child_idx].freq < self.h[left_child_idx].freq or (
                    self.h[right_child_idx].freq == self.h[left_child_idx].freq and
                    self.h[right_child_idx].ts < self.h[left_child_idx].ts
            )):
                min_child_idx = right_child_idx

            if self.h[min_child_idx].freq < self.h[idx].freq or (
                    self.h[min_child_idx].freq == self.h[idx].freq and self.h[min_child_idx].ts < self.h[idx].ts):
                self.h[idx], self.h[min_child_idx] = self.h[min_child_idx], self.h[idx]
                self.h[idx].idx, self.h[min_child_idx].idx = idx, min_child_idx
                idx = min_child_idx

            else:
                break

    def heappush(self, item):
        idx = len(self.h)
        item.idx = idx
        self.h.append(item)
        self._up(idx)

    def heappop(self):
        length = len(self.h)
        if length == 0:
            return

        self.h[0], self.h[length - 1] = self.h[length - 1], self.h[0]
        res = self.h.pop()
        self._down(0)

        return res

    def heapupdate(self, idx):
        self._down(idx)


class Node(object):

    def __init__(self, k, v, ts):
        self.k = k
        self.v = v
        self.freq = 1  # 频率
        self.ts = ts  # 创建先后
        self.idx = -1  # 位于堆中的下标


class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.h = Heap()
        self.hash_map = {}
        self.ts_generator = 0
        self.cap = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.hash_map:
            self.hash_map[key].freq += 1
            self.hash_map[key].ts = self.ts_generator
            self.ts_generator += 1
            self.h.heapupdate(self.hash_map[key].idx)

            return self.hash_map[key].v
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if self.cap == 0:
            return

        if key in self.hash_map:
            self.hash_map[key].v = value
            self.hash_map[key].ts = self.ts_generator
            self.hash_map[key].freq += 1
            self.ts_generator += 1
            self.h.heapupdate(self.hash_map[key].idx)
            return

        if len(self.h) == self.cap:
            remove_item = self.h.heappop()
            if remove_item:
                del self.hash_map[remove_item.k]

        new_item = Node(key, value, self.ts_generator)
        self.hash_map[key] = new_item
        self.ts_generator += 1
        self.h.heappush(new_item)

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
