// https://leetcode.com/problems/find-the-pivot-integer/
// algorithms
// Easy (78.24%)
// Total Accepted: 10,853
// Total Submissions: 13,871

package leetcode

func pivotInteger(n int) int {
    l2r := make([]int, n + 1, n + 1)
    r2l := make([]int, n + 1, n + 1)
    s
    sum := 0
    for i := 1; i <= n; i++ {
        sum += i
        l2r[i] = sum
    }
    
    sum = 0
    for i := n; i > 0; i-- {
        sum += i
        r2l[i] = sum
    } 
    
    for i := 1; i <= n; i++ {
        if l2r[i] == r2l[i] {
            return i
        }
    }
    
    return -1
}