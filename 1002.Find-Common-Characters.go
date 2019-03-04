// https://leetcode.com/problems/find-common-characters/
//
// algorithms
// Easy (70.81%)
// Total Accepted:    4,545
// Total Submissions: 6,419
// beats 100.0% of golang submissions

package leetcode

func commonChars(A []string) []string {
	minNum := make([]int, 26)
	for _, n := range A[0] {
		minNum[int(n)-97]++
	}
	tmp := make([]int, 26)
	for _, s := range A[1:] {
		tmp = make([]int, 26)
		for _, n := range s {
			tmp[int(n)-97]++
		}
		for i := 0; i < 26; i++ {
			minNum[i] = min(minNum[i], tmp[i])
		}
	}

	var res []string

	for i, n := range minNum {
		s := string(i + 97)
		for j := 0; j < n; j++ {
			res = append(res, s)
		}
	}

	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
