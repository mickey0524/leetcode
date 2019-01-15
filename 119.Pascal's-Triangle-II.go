// https://leetcode.com/problems/pascals-triangle-ii/
//
// algorithms
// Easy (41.26%)
// Total Accepted:    176,418
// Total Submissions: 427,585
// beats 100.0% of golang submissions

package leetcode

func getRow(rowIndex int) []int {
	if rowIndex == 0 {
		return []int{1}
	}
	if rowIndex == 1 {
		return []int{1, 1}
	}

	res := []int{1, 1}

	for i := 2; i <= rowIndex; i++ {
		tmp := make([]int, i+1)
		tmp[0] = 1
		for j := 1; j < i; j++ {
			tmp[j] = res[j-1] + res[j]
		}
		tmp[i] = 1
		res = tmp
	}

	return res
}
