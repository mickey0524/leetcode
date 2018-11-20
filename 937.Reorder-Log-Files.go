// https://leetcode.com/problems/reorder-log-files/description/
//
// algorithms
// Easy (55%)
// Total Accepted:    4.4k
// Total Submissions: 8k
// beats 100.0% of golang submissions

package leetcode

import (
	"sort"
	"strings"
)

func reorderLogFiles(logs []string) []string {
	digitIdx := 0

	for i, str := range logs {
		firstCh := str[strings.Index(str, " ")+1]
		if firstCh >= 48 && firstCh <= 57 {
			logs[digitIdx], logs[i] = logs[i], logs[digitIdx]
			digitIdx++
		}
	}

	letters := logs[digitIdx:]
	sort.Slice(letters, func(i, j int) bool {
		firstChI := strings.Index(letters[i], " ") + 1
		firstChj := strings.Index(letters[j], " ") + 1

		return letters[i][firstChI:] < letters[j][firstChj:]
	})

	return append(logs[digitIdx:], logs[:digitIdx]...)
}
