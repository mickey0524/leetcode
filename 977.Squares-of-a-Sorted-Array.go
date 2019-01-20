// https://leetcode.com/problems/squares-of-a-sorted-array/
//
// algorithms
// Easy (82.64%)
// Total Accepted:    3,875
// Total Submissions: 4,689
// beats 100.0% of golang submissions

package leetcode

func sortedSquares(A []int) []int {
	least_idx := -1
	length := len(A)

	for i := 1; i < length; i++ {
		if abs(A[i]) > abs(A[i-1]) {
			least_idx = i - 1
			break
		}
	}

	if least_idx == -1 {
		least_idx = length - 1
	}

	res := []int{A[least_idx] * A[least_idx]}

	left, right := least_idx-1, least_idx+1

	for left >= 0 || right < length {
		if left < 0 {
			res = append(res, A[right]*A[right])
			right++
		} else if right == length {
			res = append(res, A[left]*A[left])
			left--
		} else {
			if abs(A[left]) < abs(A[right]) {
				res = append(res, A[left]*A[left])
				left--
			} else {
				res = append(res, A[right]*A[right])
				right++
			}
		}
	}

	return res
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
