// https://leetcode.com/problems/permutations/
//
// algorithms
// Medium (55.16%)
// Total Accepted:    378,795
// Total Submissions: 686,762
// beats 100.0% of golang submissions

package leetcode

func permute(nums []int) [][]int {
	var res [][]int

	length := len(nums)
	if length < 2 {
		return [][]int{nums}
	}

	for i := 0; i < length; i++ {
		nums[i], nums[0] = nums[0], nums[i]
		recursiveRes := permute(nums[1:])
		for _, arr := range recursiveRes {
			arr = append([]int{nums[0]}, arr...)
			res = append(res, arr)
		}
		nums[i], nums[0] = nums[0], nums[i]
	}

	return res
}
