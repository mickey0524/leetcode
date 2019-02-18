// https://leetcode.com/problems/rotting-oranges/
//
// algorithms
// Easy (46.52%)
// Total Accepted:    3,200
// Total Submissions: 6,879
// beats 100.0% of golang submissions

package leetcode

func orangesRotting(grid [][]int) int {
	row, col := len(grid), len(grid[0])
	var rottenOranges [][]int

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == 2 {
				rottenOranges = append(rottenOranges, []int{i, j})
			}
		}
	}

	var rotNum, times int

	for {
		rotNum = 0
		length := len(rottenOranges)
		var tmp [][]int
		for i := 0; i < length; i++ {
			x, y := rottenOranges[i][0], rottenOranges[i][1]
			for _, p := range [][]int{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}} {
				if p[0] < 0 || p[0] >= row || p[1] < 0 || p[1] >= col {
					continue
				}
				if grid[p[0]][p[1]] == 1 {
					grid[p[0]][p[1]] = 2
					rotNum++
					tmp = append(tmp, []int{p[0], p[1]})
				}
			}
		}
		if rotNum == 0 {
			break
		}
		times++
		rottenOranges = tmp
	}

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == 1 {
				return -1
			}
		}
	}

	return times
}
