// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/description/
// algorithms
// Easy (33.09%)
// Total Accepted: 9.2K
// Total Submissions: 27.8K


func captureForts(forts []int) int {
    startIdx := -1
    length := len(forts)
    isEmpty := false
    res := 0

    for i := 0; i < length; i++ {
        if forts[i] == 1 {
            if startIdx == -1 {
                startIdx = i
                isEmpty = false
            } else if isEmpty {
                res = max(res, i - startIdx - 1)
                isEmpty = false
                startIdx = i
            } else {
                startIdx = i
            }
        } else if forts[i] == -1 {
            if startIdx == -1 {
                startIdx = i
                isEmpty = true
            } else if isEmpty {
                startIdx = i
            } else {
                res = max(res, i - startIdx - 1)
                isEmpty = true
                startIdx = i
            }
        }
    }

    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }

    return b
}