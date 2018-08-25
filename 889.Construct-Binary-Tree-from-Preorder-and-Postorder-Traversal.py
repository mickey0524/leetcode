# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
#
# algorithms
# Medium (53.2%)
# Total Accepted:    2.9k
# Total Submissions: 5.5k
# beats 99.33% of python submissions


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def constructFromPrePost(self, pre, post):
        """
        :type pre: List[int]
        :type post: List[int]
        :rtype: TreeNode
        """
        def resursive(pre_head, pre_tail, post_head, post_tail):
            if pre_head > pre_tail or post_head > post_tail:
                return None

            cnt_node = TreeNode(pre[pre_head])
            if pre_head != pre_tail:
                post_mid = None
                for i in xrange(post_head, post_tail + 1):
                    if post[i] == pre[pre_head + 1]:
                        post_mid = i
                        break
                if post_mid is not None:
                    pre_mid = pre_head + post_mid - post_head + 1
                    cnt_node.left = resursive(
                        pre_head + 1, pre_mid, post_head, post_mid)
                    cnt_node.right = resursive(
                        pre_mid + 1, pre_tail, post_mid + 1, post_tail - 1)

            return cnt_node

        length = len(pre)

        return resursive(0, length - 1, 0, length - 1)
