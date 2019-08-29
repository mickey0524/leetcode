# https://leetcode.com/problems/reconstruct-itinerary/
#
# algorithms
# Medium (32.36%)
# Total Accepted:    90,803
# Total Submissions: 280,619


from collections import defaultdict


class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        hash_map = defaultdict(list)
        length = len(tickets)
        is_visited = defaultdict(int)

        for source, target in tickets:
            hash_map[source].append(target)
            is_visited[(source, target)] += 1

        for k in hash_map.keys():
            hash_map[k].sort()

        res = [None]

        def recursive(cur_k, path, trip_num):
            if res[0]:
                return

            if trip_num == 0:
                res[0] = path[:]
                return

            for next_k in hash_map[cur_k]:
                is_visited_key = (cur_k, next_k)
                if is_visited[is_visited_key] == 0:
                    continue

                is_visited[is_visited_key] -= 1
                recursive(next_k, path + [next_k], trip_num - 1)
                is_visited[is_visited_key] += 1

        recursive('JFK', ['JFK'], length)

        return res[0]
