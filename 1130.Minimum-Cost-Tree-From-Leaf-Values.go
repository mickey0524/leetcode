// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
//
// algorithms
// Medium (48.12%)
// Total Accepted:    1,036
// Total Submissions: 2,153
// beats 100.0% of golang submissions

package leetcode

var res int

func mctFromLeafValues(arr []int) int {
	res = 0

	recursive(arr, 0, len(arr)-1)

	return res
}

func recursive(arr []int, start, end int) int {
	if start > end {
		return 0
	}

	if start == end {
		return arr[start]
	}

	maxItem, maxIdx := arr[start], start

	for i := start + 1; i <= end; i++ {
		if arr[i] > maxItem {
			maxItem = arr[i]
			maxIdx = i
		}
	}

	res += maxItem * (recursive(arr, start, maxIdx-1) + recursive(arr, maxIdx+1, end))

	return maxItem
}
