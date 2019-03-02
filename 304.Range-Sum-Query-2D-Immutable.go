// https://leetcode.com/problems/increasing-triplet-subsequence/description/
//
// algorithms
// Medium (31.17%)
// Total Accepted:    63,217
// Total Submissions: 202,804

package leetcode

type NumMatrix struct {
	matrix [][]int
}

func Constructor(matrix [][]int) NumMatrix {
	row := len(matrix)

	if row == 0 {
		return NumMatrix{}
	}

	col := len(matrix[0])
	sumMatrix := make([][]int, row)
	for i := 0; i < row; i++ {
		sumMatrix[i] = make([]int, col+1)
	}

	for i := 0; i < row; i++ {
		for j := 1; j <= col; j++ {
			sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j-1]
		}
	}

	return NumMatrix{
		matrix: sumMatrix,
	}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	res := 0

	for i := row1; i <= row2; i++ {
		res += this.matrix[i][col2+1] - this.matrix[i][col1]
	}

	return res
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */
