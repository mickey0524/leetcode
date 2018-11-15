// https://leetcode.com/problems/split-linked-list-in-parts/description/
//
// algorithms
// Easy (39.88%)
// Total Accepted:    34.5k
// Total Submissions: 86.5k
// beats 100.0% of golang submissions

package leetcode

func dominantIndex(nums []int) int {
	length := len(nums)

	if length == 1 {
		return 0
	}

	first, second, res := -1, -1, -1
	for idx, num := range nums {
		if num > first {
			second = first
			first = num
			res = idx
		} else if num > second {
			second = num
		}
	}

	if first >= 2*second {
		return res
	}
	return -1
}
