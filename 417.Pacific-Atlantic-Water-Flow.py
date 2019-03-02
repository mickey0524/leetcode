# https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
#
# algorithms
# Medium (36.14%)
# Total Accepted:    36,762
# Total Submissions: 101,731


class Solution(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        row = len(matrix)
        if row == 0:
            return []
        col = len(matrix[0])

        graph = [[0] * col for _ in xrange(row)]
        res = []

        for i in xrange(row):
            for j in xrange(col):
                if graph[i][j] == 3:
                    res += [i, j],
                elif graph[i][j] != 4:
                    self.resursive(matrix, graph, i, j, {(i, j)})
                    if graph[i][j] == 0:
                        graph[i][j] = 4
                    elif graph[i][j] == 3:
                        res += [i, j],
        return res

    def resursive(self, matrix, graph, i, j, path):
        if graph[i][j] == 4:
            return

        if i == 0 or j == 0:
            for x, y in path:
                graph[x][y] |= 1

        row, col = len(graph), len(graph[0])

        if i == row - 1 or j == col - 1:
            for x, y in path:
                graph[x][y] |= 2

        if graph[i][j] == 3:
            for x, y in path:
                graph[x][y] = 3
            return

        if i > 0 and matrix[i][j] >= matrix[i - 1][j] and (i - 1, j) not in path:
            self.resursive(matrix, graph, i - 1, j, path | {(i, j)})
        if i < row - 1 and matrix[i][j] >= matrix[i + 1][j] and (i + 1, j) not in path:
            self.resursive(matrix, graph, i + 1, j, path | {(i, j)})
        if j > 0 and matrix[i][j] >= matrix[i][j - 1] and (i, j - 1) not in path:
            self.resursive(matrix, graph, i, j - 1, path | {(i, j)})
        if j < col - 1 and matrix[i][j] >= matrix[i][j + 1] and (i, j + 1) not in path:
            self.resursive(matrix, graph, i, j + 1, path | {(i, j)})
            

class Solution1(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """

        n = len(matrix)
        if n:
            m = len(matrix[0])
            if not m:
                return []
        else:
            return []

        def check_range(i, j):
            return (0 <= i < n) and (0 <= j < m)

        def scan(ocean):
            queue = []
            if ocean == 'pacific':
                queue.extend([(0, j) for j in range(m)])
                queue.extend([(i, 0) for i in range(n)])
            else:
                queue.extend([(n - 1, j) for j in range(m)])
                queue.extend([(i, m - 1) for i in range(n)])
            visited = set(queue)
            while queue:
                i, j = queue.pop()

                for ii, jj in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    if (check_range(i + ii, j + jj) and matrix[i + ii][j + jj] >= matrix[i][j]
                            and (i + ii, j + jj) not in visited):
                        queue.append((i + ii, j + jj))
                        visited.add((i + ii, j + jj))

            return visited

        sol = scan('pacific').intersection(scan('atlantic'))
        return [list(x) for x in sol]


class Solution2(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return []
        self.m, self.n = len(matrix), len(matrix[0])
        #对每一个海水逆向DFS
        p = set()
        a = set()

        def dfs(x, y, set1):
            u = matrix[x][y]
            set1.add((x, y))
            if x > 0 and matrix[x-1][y] >= u:
                if (x-1, y) not in set1:
                    dfs(x-1, y, set1)
            if x+1 < self.m and matrix[x+1][y] >= u:
                if (x+1, y) not in set1:
                    dfs(x+1, y, set1)
            if y > 0 and matrix[x][y-1] >= u:
                if (x, y-1) not in set1:
                    dfs(x, y-1, set1)
            if y+1 < self.n and matrix[x][y+1] >= u:
                if (x, y+1) not in set1:
                    dfs(x, y+1, set1)
        for i in range(self.m):
            dfs(i, 0, p)
            dfs(i, self.n-1, a)
        for j in range(self.n):
            dfs(0, j, p)
            dfs(self.m-1, j, a)
        return list(p & a)
