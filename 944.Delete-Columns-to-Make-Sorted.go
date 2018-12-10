// https://leetcode.com/problems/delete-columns-to-make-sorted/
//
// algorithms
// Easy (70.84%)
// Total Accepted:    6,872
// Total Submissions: 9,701

package leetcode

func minDeletionSize(A []string) (res int) {
	ALen, strLen := len(A), len(A[0])

	for i := 0; i < strLen; i++ {
		for j := range A {
			if j < ALen-1 {
				if A[j][i] > A[j+1][i] {
					res++
					goto O
				}
			}
		}
	O:
	}
	return
}
