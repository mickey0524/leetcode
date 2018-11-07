// https://leetcode.com/problems/base-7/description/
//
// algorithms
// Easy (43.96%)
// Total Accepted:    34.2k
// Total Submissions: 77.8k
// beats 100.0% of golang submissions

package leetcode

import "strconv"

func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}
	symbol := ""
	if num < 0 {
		symbol = "-"
		num = -num
	}

	return symbol + strconv.FormatInt(int64(num), 7)
}
