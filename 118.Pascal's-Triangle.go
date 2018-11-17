// https://leetcode.com/problems/pascals-triangle/description/
//
// algorithms
// Easy (42.84%)
// Total Accepted:    205k
// Total Submissions: 478.5k
// beats 100.0% of golang submissions

package leetcode

func generate(numRows int) [][]int {
	res := make([][]int, numRows)
	if numRows == 0 {
		return res
	}
	res[0] = []int{1}

	for i := 1; i < numRows; i++ {
		level := make([]int, i+1)
		level[0] = 1
		level[i] = 1
		for j := 1; j < i; j++ {
			level[j] = res[i-1][j-1] + res[i-1][j]
		}
		res[i] = level
	}

	return res
}
