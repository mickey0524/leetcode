// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
//
// algorithms
// Easy (75.93%)
// Total Accepted:    3,555
// Total Submissions: 4,682
// beats 100.0% of golang submissions

package leetcode

func repeatedNTimes(A []int) int {
	hashMap := make(map[int]bool)

	for _, n := range A {
		if _, ok := hashMap[n]; ok {
			return n
		} else {
			hashMap[n] = true
		}
	}

	return 0
}
