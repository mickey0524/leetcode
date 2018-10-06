// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
//
// algorithms
// Easy (28.46%)
// Total Accepted:    46.7k
// Total Submissions: 164.1k
// beats 54.84% of golang submissions

package leetcode

func findPairs(nums []int, k int) int {
	if k < 0 {
		return 0
	}

	numMap := make(map[int]int)

	for _, num := range nums {
		if cntNum, ok := numMap[num]; ok {
			numMap[num] = cntNum + 1
		} else {
			numMap[num] = 1
		}
	}

	res := 0
	for key, value := range numMap {
		if k == 0 {
			if value > 1 {
				res++
			}
			continue
		}
		if _, ok := numMap[key+k]; ok {
			res++
		}
	}

	return res
}
