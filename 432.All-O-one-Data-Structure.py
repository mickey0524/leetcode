# https://leetcode.com/problems/all-oone-data-structure/
#
# algorithms
# Hard (29.33%)
# Total Accepted:    17,753
# Total Submissions: 60,523


class ListNode(object):

    def __init__(self, k):
        self.k = k
        self.pre = None
        self.next = None


class AllOne(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.kv_map = {}
        self.list_map = {}
        self.cur_max = float('-inf')
        self.cur_min = float('inf')

    def inc(self, key):
        """
        Inserts a new key <Key> with value 1. Or increments an existing key by 1.
        :type key: str
        :rtype: None
        """
        if key in self.kv_map:
            v, node = self.kv_map[key]
            if not node.pre:
                if not node.next:
                    del self.list_map[v]
                    if self.cur_min == v:
                        self.cur_min = v + 1
                else:
                    self.list_map[v] = node.next
                    self.list_map[v].pre = None
            else:
                node.pre.next = node.next
                if node.next:
                    node.next.pre = node.pre
            node.next = None
            node.pre = None
            if v + 1 in self.list_map:
                node.next = self.list_map[v + 1]
                self.list_map[v + 1].pre = node
                self.list_map[v + 1] = node
            else:
                self.list_map[v + 1] = node
                self.cur_max = max(self.cur_max, v + 1)
            self.kv_map[key][0] += 1

        else:
            node = ListNode(key)
            if 1 in self.list_map:
                node.next = self.list_map[1]
                self.list_map[1].pre = node
                self.list_map[1] = node
            else:
                self.list_map[1] = node
                self.cur_max = max(self.cur_max, 1)
                self.cur_min = min(self.cur_min, 1)
            self.kv_map[key] = [1, node]
        # self.print_list()

    def dec(self, key):
        """
        Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
        :type key: str
        :rtype: None
        """
        if key in self.kv_map:
            v, node = self.kv_map[key]
            if not node.pre:
                if not node.next:
                    del self.list_map[v]
                else:
                    self.list_map[v] = node.next
                    self.list_map[v].pre = None
            else:
                node.pre.next = node.next
                if node.next:
                    node.next.pre = node.pre
                # node.next = None
            node.next = None
            node.pre = None
            if v > 1:
                if v - 1 in self.list_map:
                    node.next = self.list_map[v - 1]
                    self.list_map[v - 1].pre = node
                    self.list_map[v - 1] = node
                else:
                    self.list_map[v - 1] = node
                self.kv_map[key][0] -= 1
                self.cur_min = min(self.cur_min, v - 1)
                if self.cur_max == v and v not in self.list_map:
                    self.cur_max = v - 1
            else:
                del self.kv_map[key]
                if 1 not in self.list_map:
                    if self.cur_max == 1:
                        self.cur_max = float('-inf')
                    if self.cur_min == 1:
                        self.cur_min = min(self.list_map.keys())
        # self.print_list()

    def getMaxKey(self):
        """
        Returns one of the keys with maximal value.
        :rtype: str
        """
        return '' if self.cur_max == float('-inf') else self.list_map[self.cur_max].k

    def getMinKey(self):
        """
        Returns one of the keys with Minimal value.
        :rtype: str
        """
        return '' if self.cur_min == float('inf') else self.list_map[self.cur_min].k

    def print_list(self):
        for k, n in self.list_map.iteritems():
            print k,
            while n:
                print n.k,
                n = n.next
            print '\n'

# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()
