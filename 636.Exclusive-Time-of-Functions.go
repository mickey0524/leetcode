// https://leetcode.com/problems/exclusive-time-of-functions/
//
// algorithms
// Medium (47.57%)
// Total Accepted:    32,290
// Total Submissions: 67,877
// beats 100.0% of golang submissions

package leetcode

import (
	"strconv"
	"strings"
)

type log struct {
	id         int
	ts         int
	startOrEnd string
	diff       int
}

func exclusiveTime(n int, logs []string) []int {
	res := make([]int, n)
	var stack []log

	for _, l := range logs {
		logArr := strings.Split(l, ":")
		id, _ := strconv.Atoi(logArr[0])
		startOrEnd := logArr[1]
		ts, _ := strconv.Atoi(logArr[2])
		stackLen := len(stack)

		if stackLen == 0 || id != stack[stackLen-1].id {
			stack = append(stack, log{
				id:         id,
				ts:         ts,
				startOrEnd: startOrEnd,
				diff:       0,
			})
		} else {
			if stack[stackLen-1].startOrEnd == "start" && startOrEnd == "end" {
				duration := ts - stack[stackLen-1].ts + 1 - stack[stackLen-1].diff
				res[id] += duration
				diff := duration + stack[stackLen-1].diff
				stack = stack[:stackLen-1]
				if len(stack) > 0 {
					stack[stackLen-2].diff += diff
				}
			} else {
				stack = append(stack, log{
					id:         id,
					ts:         ts,
					startOrEnd: startOrEnd,
					diff:       0,
				})
			}
		}
	}

	return res
}
