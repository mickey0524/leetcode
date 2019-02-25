// https://leetcode.com/problems/search-a-2d-matrix-ii/
//
// algorithms
// Medium (40.22%)
// Total Accepted:    160,168
// Total Submissions: 398,182
// beats 100.0% of golang submissions

package leetcode

func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])

	i, j := 0, n-1
	for i < m && j >= 0 {
		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] > target {
			j--
		} else {
			i++
		}
	}

	return false
}
