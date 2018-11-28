// https://leetcode.com/problems/next-greater-element-i/description/
//
// algorithms
// Easy (57.62%)
// Total Accepted:    75.6k
// Total Submissions: 131.2k

package leetcode

func nextGreaterElement(findNums []int, nums []int) []int {
	res := make([]int, 0, len(findNums))
	dict := make(map[int]int)
	for k, v := range nums {
		dict[v] = k
	}

	for i := 0; i < len(findNums); i++ {
		j := dict[findNums[i]] + 1
		for {
			if j == len(nums) {
				res = append(res, -1)
				break
			}
			if nums[j] > findNums[i] {
				res = append(res, nums[j])
				break
			}
			j++
		}
	}
	return res
}
