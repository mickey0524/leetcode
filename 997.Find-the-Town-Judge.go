// https://leetcode.com/problems/find-the-town-judge/
//
// algorithms
// Easy (46.92%)
// Total Accepted:    3,310
// Total Submissions: 7,055
// beats 100.0% of golang submissions

package leetcode

func findJudge(N int, trust [][]int) int {
	if N == 1 {
		return 1
	}
	arr := make([]int, N+1)
	judgeIdx := -1

	for _, t := range trust {
		arr[t[0]] = -1
		if arr[t[1]] == -1 {
			continue
		}
		arr[t[1]]++
		if arr[t[1]] == N-1 {
			judgeIdx = t[1]
		}
	}

	if judgeIdx > -1 && arr[judgeIdx] != -1 {
		return judgeIdx
	}

	return -1
}
