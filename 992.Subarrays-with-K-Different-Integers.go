// https://leetcode.com/problems/subarrays-with-k-different-integers/
//
// algorithms
// Hard (38.74%)
// Total Accepted:    1,204
// Total Submissions: 3,108
// beats 100.0% of golang submissions
// 典型的 Two Pointer 问题，使用 hashMap 存储数字的最新下标，并依此来判断是否存在重复
// 当 diffNum 等于 K 的时候，我们移动左指针来判断是否符合要求
// 当 diffNum 大于 K 的时候，需要移动左指针来使得 diffNum 等于 k

package leetcode

func subarraysWithKDistinct(A []int, K int) int {
	length := len(A)
	hashMap := make(map[int]int)

	head, tail, diffNum, res := 0, 0, 0, 0
	for ; tail < length; tail++ {
		if _, exist := hashMap[A[tail]]; !exist {
			diffNum++
		}
		hashMap[A[tail]] = tail
		if diffNum == K {
			res++
			left := head
			for hashMap[A[left]] > left {
				res++
				left++
			}
		} else if diffNum == K+1 {
			res++
			for diffNum > K {
				if head == hashMap[A[head]] {
					diffNum--
					delete(hashMap, A[head])
				}
				head++
			}
			left := head
			for hashMap[A[left]] > left {
				res++
				left++
			}
		}
	}

	return res
}
