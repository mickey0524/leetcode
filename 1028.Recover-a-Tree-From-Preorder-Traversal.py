# https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
# Hard (73.79%)
# Total Accepted:    2,273
# Total Submissions: 3,097
# beats 70.67% of python submissions


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def recoverFromPreorder(self, S):
        """
        :type S: str
        :rtype: TreeNode
        """
        length = len(S)
        i = 0
        while i < length and S[i] != '-':
            i += 1
        root = TreeNode(S[:i])

        nodes = []
        while i < length:
            j = i
            while j < length and S[j] == '-':
                j += 1
            depth = j - i
            i = j
            while i < length and S[i] != '-':
                i += 1
            v = S[j:i]
            nodes.append((depth, v))

        length = len(nodes)
        idx = [0]

        def recursive(node, depth):
            while idx[0] < length and nodes[idx[0]][0] == depth + 1:
                new_node = TreeNode(nodes[idx[0]][1])
                if node.left:
                    node.right = new_node
                else:
                    node.left = new_node
                idx[0] += 1
                recursive(new_node, depth + 1)

        recursive(root, 0)

        return root
