# https://leetcode.com/problems/find-mode-in-binary-search-tree/
#
# algorithms
# Easy (39.8%)
# Total Accepted:    59,794
# Total Submissions: 150,231
# beats 100.0% of python submissions


class Solution(object):

    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # res[0] 为最终结果，res[1] 为当前最大的众数，res[2] 为当前的数有多少个，res[3] 为前一个遍历的数
        self.res = [[], 0, 0, None]

        def recursive(node):
            if not node:
                return

            recursive(node.left)

            if self.res[3] is None:
                self.res = [[node.val], 1, 1, node.val]
            else:
                if node.val == self.res[3]:
                    self.res[2] += 1
                else:
                    self.res[2] = 1

                if self.res[2] == self.res[1]:
                    self.res[0] += node.val,
                elif self.res[2] > self.res[1]:
                    self.res[0] = [node.val]
                    self.res[1] = self.res[2]

                self.res[3] = node.val

            recursive(node.right)

        recursive(root)

        return self.res[0]
