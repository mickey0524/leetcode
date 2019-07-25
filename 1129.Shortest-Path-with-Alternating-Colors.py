# https://leetcode.com/problems/shortest-path-with-alternating-colors/
# Medium (35.02%)
# Total Accepted:    2,973
# Total Submissions: 8,484


from collections import deque


class Solution(object):
    def shortestAlternatingPaths(self, n, red_edges, blue_edges):
        """
        :type n: int
        :type red_edges: List[List[int]]
        :type blue_edges: List[List[int]]
        :rtype: List[int]
        """
        red = [[] for _ in xrange(n)]
        blue = [[] for _ in xrange(n)]
        res = [float('inf')] * n
        res[0] = 0

        for source, target in red_edges:
            red[source] += target,

        for source, target in blue_edges:
            blue[source] += target,

        def bfs(is_red):
            q = deque([0, -1])
            path = 0
            is_visited = {
                (0, True): True,
                (0, False): True,
            }

            while True:
                cur = q.popleft()
                if cur == -1:
                    if not q:
                        break
                    path += 1
                    q.append(-1)
                    is_red = not is_red
                else:
                    res[cur] = min(res[cur], path)
                    arr = red[cur] if is_red else blue[cur]
                    # is_red = not is_red

                    for i in arr:
                        if (i, is_red) in is_visited:
                            continue
                        is_visited[(i, is_red)] = True
                        q.append(i)

        bfs(True)
        bfs(False)

        for i in xrange(n):
            if res[i] == float('inf'):
                res[i] = -1

        return res
