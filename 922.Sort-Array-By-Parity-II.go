// https://leetcode.com/problems/evaluate-division/description/
//
// algorithms
// Easy (68.13%)
// Total Accepted:    6.2k
// Total Submissions: 9.1k
// beats 56.52% of golang submissions

package leetcode

func sortArrayByParityII(A []int) []int {
	length := len(A)

	for i := 0; i < length; i++ {
		if i%2 == 0 && A[i]%2 == 1 {
			for j := i + 1; j < length; j++ {
				if A[j]%2 == 0 {
					A[i], A[j] = A[j], A[i]
					break
				}
			}
		} else if i%2 == 1 && A[i]%2 == 0 {
			for j := i + 1; j < length; j++ {
				if A[j]%2 == 1 {
					A[i], A[j] = A[j], A[i]
					break
				}
			}
		}
	}

	return A
}
