// https://leetcode.com/problems/duplicate-zeros/
//
// algorithms
// Easy (58.54%)
// Total Accepted:    4,796
// Total Submissions: 8,192

package leetcode

func duplicateZeros(arr []int) {
	length := len(arr)
	tmp := make([]int, length)
	var idx int

	for i := 0; i < length; i++ {
		if arr[i] == 0 {
			tmp[idx] = 0
			idx++
			if idx == length {
				break
			}
			tmp[idx] = 0
		} else {
			tmp[idx] = arr[i]
		}
		idx++
		if idx == length {
			break
		}
	}

	for i := 0; i < length; i++ {
		arr[i] = tmp[i]
	}

}
