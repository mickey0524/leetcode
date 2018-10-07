// https://leetcode.com/problems/largest-plus-sign/description/
//
// algorithms
// Medium (41.4%)
// Total Accepted:    9.4k
// Total Submissions: 22.7k
// beats 100.0% of golang submissions
// 这道题是用动态规划的思想解决的，其实关键就是当前点的权值给予的是上下左右四个点，因此，
// 用一个struct代表当前点上下左右的权值，取min就是当前点的权值，再取最大值即可
package leetcode

type point struct {
	Left   int
	Right  int
	Top    int
	Bottom int
}

func orderOfLargestPlusSign(N int, mines [][]int) int {
	grid := make([][]*point, N)
	for i := 0; i < N; i++ {
		grid[i] = make([]*point, N)
	}

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			grid[i][j] = &point{
				Left:   1,
				Right:  1,
				Top:    1,
				Bottom: 1,
			}
		}
	}

	for _, p := range mines {
		grid[p[0]][p[1]] = &point{
			Left:   0,
			Right:  0,
			Top:    0,
			Bottom: 0,
		}
	}

	for i := N - 1; i >= 0; i-- {
		for j := N - 1; j >= 0; j-- {
			if grid[i][j].Left == 0 {
				continue
			}
			if j != N-1 && grid[i][j+1].Right != 0 {
				grid[i][j].Right = 1 + grid[i][j+1].Right
			}
			if i != N-1 && grid[i+1][j].Bottom != 0 {
				grid[i][j].Bottom = 1 + grid[i+1][j].Bottom
			}
		}
	}

	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			if grid[i][j].Left == 0 {
				continue
			}
			if j != 0 && grid[i][j-1].Left != 0 {
				grid[i][j].Left = 1 + grid[i][j-1].Left
			}
			if i != 0 && grid[i-1][j].Top != 0 {
				grid[i][j].Top = 1 + grid[i-1][j].Top
			}
		}
	}

	res := 0
	for _, line := range grid {
		for _, p := range line {
			if p.Left == 0 {
				continue
			}
			pMin := min(p.Left, p.Right, p.Top, p.Bottom)
			if pMin > res {
				res = pMin
			}
		}
	}

	return res
}

func min(args ...int) int {
	res := args[0]

	for _, n := range args {
		if n < res {
			res = n
		}
	}

	return res
}
