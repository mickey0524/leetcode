// https://leetcode.com/problems/compare-version-numbers/
//
// algorithms
// Easy (48.56%)
// Total Accepted:    196,893
// Total Submissions: 405,472
// beats 100.0% of golang submissions

package leetcode

func twoSum(numbers []int, target int) []int {
	hashMap := make(map[int]int)

	for idx, n := range numbers {
		if v, ok := hashMap[target-n]; ok {
			if idx > v {
				return []int{v + 1, idx + 1}
			} else {
				return []int{idx + 1, v + 1}
			}
		} else {
			hashMap[n] = idx
		}
	}

	return []int{}
}
