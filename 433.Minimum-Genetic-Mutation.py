# https://leetcode.com/problems/minimum-genetic-mutation/description/
#
# algorithms
# Medium (36.58%)
# Total Accepted:    17.1k
# Total Submissions: 47.3k


from collections import deque


class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        hash_map = {}
        for gene in bank:
            hash_map[gene] = True

        if end not in hash_map:
            return -1

        queue = deque([start, '#'])
        mutation = 0
        genes = ['A', 'C', 'G', 'T']

        while True:
            head = queue[0]
            queue.popleft()
            if head == '#':
                if len(queue) == 0:
                    break
                queue.append('#')
                mutation += 1
            else:
                for i in xrange(len(head)):
                    for g in genes:
                        tmp = head[:i] + g + head[i + 1:]
                        if head == tmp:
                            continue
                        if tmp == end:
                            return mutation + 1
                        if hash_map.get(tmp, False):
                            queue.append(tmp)
                            hash_map[tmp] = False

        return -1
