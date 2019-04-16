// https://leetcode.com/problems/walking-robot-simulation/
//
// algorithms
// Medium (43.43%)
// Total Accepted:    9,779
// Total Submissions: 22,516

package leetcode

func lenLongestFibSubseq(A []int) int {
	length := len(A)

	hashMap := make(map[int]bool)
	for _, n := range A {
		hashMap[n] = true
	}

	res := 0

	for i := 0; i < length-2; i++ {
		if res >= length-i {
			break
		}
		for j := i + 1; j < length-1; j++ {
			if res >= length-j+1 {
				break
			}
			fib := []int{A[i], A[j]}
			pre, after := 0, 1
			for {
				if _, ok := hashMap[fib[pre]+fib[after]]; ok {
					fib = append(fib, fib[pre]+fib[after])
					pre++
					after++
				} else {
					break
				}
			}
			if len(fib) >= 3 {
				res = max(res, len(fib))
			}
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
