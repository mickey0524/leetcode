// https://leetcode.com/problems/rotate-string/description/
//
// algorithms
// Easy (48.63%)
// Total Accepted:    26.6k
// Total Submissions: 54.7k
// beats 100.0% of golang submissions

package leetcode

func rotateString(A string, B string) bool {
	if A == B {
		return true
	}

	lenA, lenB := len(A), len(B)

	if lenA != lenB {
		return false
	}

	for idx, _ := range A {
		if A[idx:] == B[:lenA-idx] && A[:idx] == B[lenA-idx:] {
			return true
		}
	}

	return false
}
