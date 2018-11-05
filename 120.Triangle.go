// https://leetcode.com/problems/triangle/description/
//
// algorithms
// Medium (36.97%)
// Total Accepted:    154.4k
// Total Submissions: 417.6k
// beats 100.0% of golang submissions

package leetcode

import "sort"

func minimumTotal(triangle [][]int) int {
	length := len(triangle)
	if length == 0 {
		return 0
	}

	arrSize := len(triangle[length-1])
	pathArr := make([]int, arrSize)

	for i := 0; i < len(triangle[0]); i++ {
		pathArr[i] = triangle[0][i]
	}

	level := 1
	for {
		if level == length {
			break
		}
		temp := make([]int, arrSize)
		temp[0] = pathArr[0] + triangle[level][0]
		for j := 1; j < level; j++ {
			temp[j] = minInt(pathArr[j], pathArr[j-1]) + triangle[level][j]
		}
		temp[level] = pathArr[level-1] + triangle[level][level]
		level++
		copy(pathArr, temp)
	}

	sort.Sort(sort.IntSlice(pathArr))

	return pathArr[0]
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}
