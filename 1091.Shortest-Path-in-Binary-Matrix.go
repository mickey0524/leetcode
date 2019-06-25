// https://leetcode.com/problems/shortest-path-in-binary-matrix/
//
// algorithms
// Medium (35.69%)
// Total Accepted:    3,868
// Total Submissions: 10,837
// beats 100.0% of golang submissions

package leetcode

type point struct {
	i   int
	j   int
	sum int
}

func shortestPathBinaryMatrix(grid [][]int) int {
	length := len(grid)
	delta := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}

	if grid[0][0] == 1 {
		return -1
	}

	if length == 1 {
		return 1
	}

	var q []point
	q = append(q, point{
		i:   0,
		j:   0,
		sum: 1,
	})

	for len(q) > 0 {
		curP := q[0]
		q = q[1:]
		for _, d := range delta {
			if checkPosition(curP.i+d[0], curP.j+d[1], length, grid) {
				nextI, nextJ := curP.i+d[0], curP.j+d[1]
				if nextI == length-1 && nextJ == length-1 {
					return curP.sum + 1
				}
				q = append(q, point{
					i:   nextI,
					j:   nextJ,
					sum: curP.sum + 1,
				})
				grid[nextI][nextJ] = 1
			}
		}
	}

	return -1
}

func checkPosition(i, j, length int, grid [][]int) bool {
	if i < 0 || i >= length || j < 0 || j >= length || grid[i][j] == 1 {
		return false
	}

	return true
}
