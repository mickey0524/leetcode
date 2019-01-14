// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
//
// algorithms
// Easy (54.78%)
// Total Accepted:    3,287
// Total Submissions: 6,000
// beats 100.0% of golang submissions

package leetcode

import "sort"

func largestPerimeter(A []int) int {
	sort.Sort(sort.Reverse(sort.IntSlice(A)))

	res, length := 0, len(A)
	for i := 0; i < length-2; i++ {
		if res >= A[i]*3 {
			break
		}
		for j := i + 1; j < length-1; j++ {
			if A[i] > 2*A[j] {
				break
			}
			for k := j + 1; k < length; k++ {
				if A[k]+A[j] > A[i] {
					if A[k]+A[j]+A[i] > res {
						res = A[k] + A[j] + A[i]
					}
					break
				}
			}
		}
	}

	return res
}
