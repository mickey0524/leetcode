# https://leetcode.com/problems/clone-graph/description/
#
# algorithms
# Medium (25.08%)
# Total Accepted:    180.2K
# Total Submissions: 718.5K
# beats 50.23% of python submissions

# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []


class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def __init__(self):
        self.hash_map = {}

    def cloneGraph(self, node):
        if not node:
            return node

        new_node = UndirectedGraphNode(node.label)
        self.hash_map[node.label] = new_node

        for neighbor in node.neighbors:
            if neighbor.label in self.hash_map:
                new_node.neighbors.append(self.hash_map[neighbor.label])
            else:
                new_node.neighbors.append(self.cloneGraph(neighbor))

        return new_node
