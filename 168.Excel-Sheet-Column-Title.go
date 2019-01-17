// https://leetcode.com/problems/excel-sheet-column-title/
//
// algorithms
// Easy (28.32%)
// Total Accepted:    159,684
// Total Submissions: 563,827
// beats 100.0% of golang submissions

package leetcode

func convertToTitle(n int) string {
	var res []byte

	for n > 0 {
		n -= 1
		remainder := n % 26
		res = append([]byte{byte('A' + remainder)}, res...)
		n /= 26
	}

	return string(res)
}
