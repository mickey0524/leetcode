// https://leetcode.com/problems/pancake-sorting/
//
// algorithms
// Medium (61.56%)
// Total Accepted:    2,450
// Total Submissions: 3,980
// beats 100.0% of golang submissions

package leetcode

var hashMap map[int]int

func pancakeSort(A []int) []int {
	var res []int

	length := len(A)
	if length < 2 {
		return res
	}

	hashMap = make(map[int]int)
	for idx, n := range A {
		hashMap[n] = idx
	}

	tail := length
	for tail > 0 {
		for tail > 0 && A[tail-1] == tail {
			tail--
		}
		if tail == 0 {
			break
		}
		if hashMap[tail] > 0 {
			res = append(res, hashMap[tail]+1)
			reverse(A, 0, hashMap[tail])
		}
		res = append(res, tail)
		reverse(A, 0, tail-1)
		tail--
	}

	return res
}

func reverse(A []int, head, tail int) {
	for head < tail {
		hashMap[A[head]], hashMap[A[tail]] = tail, head
		A[head], A[tail] = A[tail], A[head]
		head++
		tail--
	}
}
