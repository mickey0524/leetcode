// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//
// algorithms
// Easy (32.04%)
// Total Accepted:    430,978
// Total Submissions: 1,345,004
// beats 100.0% of golang submissions

package leetcode

func strStr(haystack string, needle string) int {
	if needle == "" || haystack == needle {
		return 0
	}

	return kmp(haystack, needle)
}

func kmp(source, target string) int {

	sourceLen, targetLen := len(source), len(target)

	if targetLen > sourceLen {
		return -1
	}

	next := genNext(target)
	i, j := 0, 0

	for i < sourceLen && j < targetLen {
		if j == -1 || source[i] == target[j] {
			i++
			j++
		} else {
			j = next[j]
		}
	}

	if j == targetLen {
		return i - targetLen
	}

	return -1
}

func genNext(target string) []int {
	length := len(target)
	next := make([]int, length)
	next[0] = -1

	i, k := 0, -1
	for i < length-1 {
		if k == -1 || target[i] == target[k] {
			k++
			i++
			next[i] = k
		} else {
			k = next[k]
		}
	}

	return next
}
