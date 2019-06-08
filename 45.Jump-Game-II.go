// https://leetcode.com/problems/jump-game-ii/
//
// algorithms
// Hard (28.10%)
// Total Accepted:    171,079
// Total Submissions: 608,705
// beats 100.0% of golang submissions

package leetcode

func jump(nums []int) int {
	length := len(nums)
	if length < 2 {
		return 0
	}

	l, r, res := nums[0], nums[0], 1
	for i := 1; i < length; i++ {
		if i > l {
			l = r
			res++
		}
		if i+nums[i] > r {
			r = i + nums[i]
		}
		if l >= length-1 {
			return res
		}
	}

	return 0
}
