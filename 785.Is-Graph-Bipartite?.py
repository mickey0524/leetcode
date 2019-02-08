# https://leetcode.com/problems/is-graph-bipartite/
#
# algorithms
# Medium (41.93%)
# Total Accepted:    31,602
# Total Submissions: 75,360
# beats 100.0% of python submissions

from collections import deque


class Solution(object):
    def isBipartite(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: bool
        """
        node_num = len(graph)

        subsets = [None] * node_num

        for i in xrange(node_num):
            if subsets[i] is None:
                subsets[i] = 1
                queue = deque([i])
                while len(queue) > 0:
                    cnt_node = queue.popleft()
                    edges = graph[cnt_node]
                    for e in edges:
                        if subsets[e] is None:
                            subsets[e] = -subsets[cnt_node]
                            queue.append(e)
                        elif subsets[e] == subsets[cnt_node]:
                            return False

        return True
