// https://leetcode.com/problems/two-sum/description/
//
// algorithms
// Easy (42.68%)
// Total Accepted:    1,597,390
// Total Submissions: 3,742,467
// beats 100.0% of golang submissions

package leetcode

func twoSum(nums []int, target int) []int {
	hashMap := make(map[int]int)

	for idx, n := range nums {
		diff := target - n
		if v, exist := hashMap[diff]; exist {
			return []int{v, idx}
		}
		hashMap[n] = idx
	}

	return []int{}
}
