// https://leetcode.com/problems/excel-sheet-column-number/
//
// algorithms
// Easy (50.46%)
// Total Accepted:    200,278
// Total Submissions: 396,896

package leetcode

func titleToNumber(s string) int {
	length := len(s)
	if length == 0 {
		return 0
	}

	base, res := 1, 0
	for i := length - 1; i >= 0; i-- {
		res += int(s[i]-'A'+1) * base
		base *= 26
	}

	return res
}
