// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
//
// algorithms
// Medium (34.54%)
// Total Accepted:    36,097
// Total Submissions: 104,501

package leetcode

// 这是我的做法，从 matrix 中的每个0进行四个方向的发散
// 遇到比当前 pathNum 小停止递归
func updateMatrix(matrix [][]int) [][]int {
	row := len(matrix)
	if row == 0 {
		return matrix
	}
	col := len(matrix[0])

	initOne := max(row, col) + 1

	var zeroPoints [][]int
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if matrix[i][j] == 0 {
				zeroPoints = append(zeroPoints, []int{i, j})
			} else {
				matrix[i][j] = initOne
			}
		}
	}

	for _, p := range zeroPoints {
		recursive(&matrix, p[0], p[1], 0)
	}

	return matrix
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func recursive(matrix *[][]int, i, j, num int) {
	row, col := len(*matrix), len((*matrix)[0])
	(*matrix)[i][j] = num

	if i-1 >= 0 && (num+1) < (*matrix)[i-1][j] {
		recursive(matrix, i-1, j, num+1)
	}

	if i+1 < row && (num+1) < (*matrix)[i+1][j] {
		recursive(matrix, i+1, j, num+1)
	}

	if j-1 >= 0 && (num+1) < (*matrix)[i][j-1] {
		recursive(matrix, i, j-1, num+1)
	}

	if j+1 < col && (num+1) < (*matrix)[i][j+1] {
		recursive(matrix, i, j+1, num+1)
	}
}

// 这个方法是 ac 中速度最快的方法，思路非常巧妙，其实从两个方向进行遍历，覆盖全部的 0 值即可
func updateMatrix1(matrix [][]int) [][]int {
	m, n := len(matrix), len(matrix[0])
	MIN := m * n

	// 根据 左方 和 上方 的格子，更新 (i,j)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] == 0 {
				continue
			}

			// 如果当前元素不是0，则把当前元素设置成一个固定值
			matrix[i][j] = MIN

			if i-1 >= 0 {
				// 和上方的元素进行比较
				matrix[i][j] = min(matrix[i][j], matrix[i-1][j]+1)
			}
			if j-1 >= 0 {
				// 和左边的元素进行比较
				matrix[i][j] = min(matrix[i][j], matrix[i][j-1]+1)
			}
		}
	}

	// 根据 右方 和 下方 的格子，更新 (i,j)
	for i := m - 1; 0 <= i; i-- {
		for j := n - 1; 0 <= j; j-- {
			if matrix[i][j] == 0 {
				continue
			}

			if i+1 < m {
				matrix[i][j] = min(matrix[i][j], matrix[i+1][j]+1)
			}
			if j+1 < n {
				matrix[i][j] = min(matrix[i][j], matrix[i][j+1]+1)
			}
		}
	}

	return matrix
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
