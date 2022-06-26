// https://leetcode.com/problems/count-asterisks/
//
// algorithms
// Easy (79.41%)
// Total Accepted:    13.5K
// Total Submissions: 17K

package leetcode


func countAsterisks(s string) int {
    allStarNum := 0
    pairStarNum := 0
    pairBegin := false

    for _, ch := range s {
        if ch == '*' {
            allStarNum++
            if pairBegin {
                pairStarNum++
            }
        } else if ch == '|' {
            pairBegin = !pairBegin
        }
    }

    return allStarNum - pairStarNum
}