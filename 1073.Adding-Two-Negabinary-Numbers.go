// https://leetcode.com/problems/adding-two-negabinary-numbers/
//
// algorithms
// Medium (26.02%)
// Total Accepted:    1,239
// Total Submissions: 4,762
// beats 100.0% of golang submissions

package leetcode

func addNegabinary(arr1 []int, arr2 []int) []int {
	len1, len2 := len(arr1), len(arr2)

	var idx1, idx2 int
	var res []int
	var carry int
	sample := -1

	for i := 1; i <= max(len1, len2); i++ {
		idx1 = len1 - i
		idx2 = len2 - i

		bit := carry * sample
		if idx1 >= 0 {
			bit += arr1[idx1]
		}
		if idx2 >= 0 {
			bit += arr2[idx2]
		}

		if bit > 0 {
			carry = bit / 2
			res = append([]int{bit % 2}, res...)
			sample = -1
		} else if bit < 0 {
			carry = 1
			res = append([]int{1}, res...)
			sample = 1
		} else {
			res = append([]int{0}, res...)
			carry = 0
		}
	}

	if carry != 0 {
		res = append([]int{1, 1}, res...)
	} else {
		var i int
		for ; i < len(res)-1; i++ {
			if res[i] != 0 {
				break
			}
		}
		res = res[i:]
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
