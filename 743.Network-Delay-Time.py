# https://leetcode.com/problems/network-delay-time/description/
#
# algorithms
# Easy (37.53%)
# Total Accepted:    14.3K
# Total Submissions: 38.1K
# beats 97.71% of python submissions
# 简单的dijkstra


class Solution(object):
    def networkDelayTime(self, times, N, K):
        """
        :type times: List[List[int]]
        :type N: int
        :type K: int
        :rtype: int
        """
        graph = [[float('inf')] * N for _ in xrange(N)]

        for u, k, w in times:
            graph[u - 1][k - 1] = w

        distance = graph[K - 1][:]
        distance[K - 1] = 0
        is_visited = [False] * N
        is_visited[K - 1] = True

        for _ in xrange(N - 1):
            cnt_min_index, cnt_min = None, float('inf')
            for i in xrange(N):
                if not is_visited[i] and distance[i] < cnt_min:
                    cnt_min = distance[i]
                    cnt_min_index = i
            if cnt_min_index is None:
                break
            is_visited[cnt_min_index] = True
            for i in xrange(N):
                tmp_dis = cnt_min + graph[cnt_min_index][i]
                if not is_visited[i] and distance[i] > tmp_dis:
                    distance[i] = tmp_dis

        return -1 if float('inf') in distance else max(distance)
