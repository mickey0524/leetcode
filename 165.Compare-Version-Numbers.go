// https://leetcode.com/problems/compare-version-numbers/
//
// algorithms
// Medium (22.12%)
// Total Accepted:    120,717
// Total Submissions: 545,849
// beats 100.0% of golang submissions

package leetcode

import (
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	if version1 == version2 {
		return 0
	}

	arr1 := strings.Split(version1, ".")
	arr2 := strings.Split(version2, ".")
	len1, len2 := len(arr1), len(arr2)

	i, j := 0, 0
	for i < len1 && j < len2 {
		a, _ := strconv.Atoi(arr1[i])
		b, _ := strconv.Atoi(arr2[j])
		if a > b {
			return 1
		} else if a < b {
			return -1
		}
		i++
		j++
	}

	if i < len1 {
		for ; i < len1; i++ {
			n, _ := strconv.Atoi(arr1[i])
			if n != 0 {
				break
			}
		}
	}

	if j < len2 {
		for ; j < len2; j++ {
			n, _ := strconv.Atoi(arr2[j])
			if n != 0 {
				break
			}
		}
	}

	if i == len1 && j == len2 {
		return 0
	}

	if i < len1 {
		return 1
	}

	return -1
}
