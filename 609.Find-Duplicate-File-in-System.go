// https://leetcode.com/problems/find-duplicate-file-in-system/
//
// algorithms
// Easy (53.75%)
// Total Accepted:    20,984
// Total Submissions: 39,043
// beats 100.0% of golang submissions

package leetcode

import "strings"

func findDuplicate(paths []string) [][]string {
	hashMap := make(map[string][]string)

	for _, p := range paths {
		arr := strings.Fields(p)
		directory := arr[0]
		for _, file := range arr[1:] {
			leftBracketIdx := strings.Index(file, "(")
			file_path := directory + "/" + file[:leftBracketIdx]
			content := file[leftBracketIdx+1 : len(file)-1]
			if _, ok := hashMap[content]; ok {
				hashMap[content] = append(hashMap[content], file_path)
			} else {
				hashMap[content] = []string{file_path}
			}
		}
	}

	var res [][]string

	for _, arr := range hashMap {
		if len(arr) > 1 {
			res = append(res, arr)
		}
	}

	return res
}
