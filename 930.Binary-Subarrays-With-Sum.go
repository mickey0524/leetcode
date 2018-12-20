// https://leetcode.com/problems/binary-subarrays-with-sum/
//
// algorithms
// Medium (34.92%)
// Total Accepted:    5,410
// Total Submissions: 15,492
// beats 100.0% of golang submissions
// 这道题目我的思路是要分开算 S 等于 0 和不等于 0的情况，会清晰很多
// 当 S = 0 的时候，其实就是求连续 0 串中串的和
// 当 S != 0 的时候，以 0,0,1,0,1,0,0,0,1,0 举例
// 是求满足条件的两端的 0 的数目，比如 中间的 1,0,1 左边有两个 0，右边有三个 0
// 这个时候左边取 0 - 2 个 0，右边取 0 - 3 个 0 都是符合条件的解法
// 以此类推

package leetcode

func numSubarraysWithSum(A []int, S int) int {
	length := len(A)
	if length < S {
		return 0
	}

	if S == 0 {
		zeros, res := 0, 0
		for i := 0; i < length; i++ {
			if A[i] == 0 {
				zeros++
			} else {
				res += ((1 + zeros) * zeros / 2)
				zeros = 0
			}
		}
		res += ((1 + zeros) * zeros / 2)
		return res
	}

	head, tail := 0, 0
	cntSum, res := 0, 0

	for tail < length {
		cntSum += A[tail]
		if cntSum == S {
			leftZeros := 0
			for i := head; i < tail; i++ {
				if A[i] == 1 {
					leftZeros = i - head
					head = i + 1
					cntSum--
					break
				}
			}
			rightZeros := 0
			j := tail + 1
			for ; j < length; j++ {
				if A[j] == 0 {
					rightZeros++
				} else {
					break
				}
			}
			res += (leftZeros + 1) * (rightZeros + 1)
			if j < length {
				tail = j
			} else {
				break
			}
		} else {
			tail++
		}
	}

	return res
}
