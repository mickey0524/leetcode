// https://leetcode.com/problems/shortest-bridge/description/
//
// algorithms
// Medium (41.25%)
// Total Accepted:    3.3k
// Total Submissions: 8k
// 思路是先找出两个island，将其中一个置为2，然后求1和2的最小距离，bfs，dfs均可

package leetcode

var onePoints [][]int
var isVisited [][]int
var res int

func shortestBridge(A [][]int) int {
	row, col := len(A), len(A[0])
	onePoints = [][]int{}
	isVisited = make([][]int, row)
	for i := 0; i < row; i++ {
		isVisited[i] = make([]int, col)
	}
	res = 1 << 31

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if A[i][j] == 1 {
				findOne(A, i, j)
				goto compare
			}
		}
	}

compare:
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			isVisited[i][j] = -1
		}
	}
	for _, p := range onePoints {
		findPath(A, p[0], p[1], 0)
		if res == 2 {
			return 1
		}
	}

	return res - 1
}

func findOne(A [][]int, i, j int) {
	A[i][j] = 2
	isVisited[i][j] = 1
	onePoints = append(onePoints, []int{i, j})
	row, col := len(A), len(A[0])

	if i > 0 && A[i-1][j] == 1 && isVisited[i-1][j] != 1 {
		findOne(A, i-1, j)
	}

	if i < row-1 && A[i+1][j] == 1 && isVisited[i+1][j] != 1 {
		findOne(A, i+1, j)
	}

	if j > 0 && A[i][j-1] == 1 && isVisited[i][j-1] != 1 {
		findOne(A, i, j-1)
	}

	if j < col-1 && A[i][j+1] == 1 && isVisited[i][j+1] != 1 {
		findOne(A, i, j+1)
	}
}

func findPath(A [][]int, i, j, path int) {
	if A[i][j] == 1 {
		if path < res {
			res = path
		}
		return
	}
	row, col := len(A), len(A[0])

	if path >= res {
		return
	}

	if isVisited[i][j] != -1 && path >= isVisited[i][j] {
		return
	}
	isVisited[i][j] = path
	if i > 0 && A[i-1][j] != 2 {
		findPath(A, i-1, j, path+1)
	}

	if i < row-1 && A[i+1][j] != 2 {
		findPath(A, i+1, j, path+1)
	}

	if j > 0 && A[i][j-1] != 2 {
		findPath(A, i, j-1, path+1)
	}

	if j < col-1 && A[i][j+1] != 2 {
		findPath(A, i, j+1, path+1)
	}
}
