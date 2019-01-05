// https://leetcode.com/problems/hamming-distance/
//
// algorithms
// Easy (69.73%)
// Total Accepted:    207,158
// Total Submissions: 297,104
// beats 100.0% of golang submissions

package leetcode

import "fmt"

func hammingDistance(x int, y int) int {
	diff := x ^ y
	fmt.Println(diff)
	return numberOfOne(diff)
}

func numberOfOne(x int) int {
	res := 0
	for x != 0 {
		res++
		x &= (x - 1)
	}

	return res
}
