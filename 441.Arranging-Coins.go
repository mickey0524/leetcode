// https://leetcode.com/problems/arranging-coins/description/
//
// algorithms
// Easy (33.38%)
// Total Accepted:    55.1k
// Total Submissions: 150.1k
// beats 100.0% of golang submissions

package leetcode

func arrangeCoins(n int) int {
	if n <= 1 {
		return n
	}

	head, tail, mid := 1, n, 0

	for {
		if head >= tail {
			break
		}
		mid = head + (tail-head)/2
		floors := (1 + mid) * mid / 2
		if floors == n {
			return mid
		} else if floors > n {
			tail = mid
		} else {
			head = mid + 1
		}
	}

	return tail - 1
}
