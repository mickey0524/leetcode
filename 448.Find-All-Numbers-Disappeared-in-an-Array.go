// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//
// algorithms
// Easy (52.15%)
// Total Accepted:    125,479
// Total Submissions: 240,624

package leetcode

func findDisappearedNumbers(nums []int) []int {
	length := len(nums)

	times := make([]int, length+1)

	for _, n := range nums {
		times[n]++
	}

	var res []int

	for i := 1; i <= length; i++ {
		if times[i] == 0 {
			res = append(res, i)
		}
	}

	return res
}
