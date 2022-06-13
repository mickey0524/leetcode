// https://leetcode.com/problems/calculate-amount-paid-in-taxes/
//
// algorithms
// Easy (60.48%)
// Total Accepted:    15K
// Total Submissions: 24.8K

package leetcode

func calculateTax(brackets [][]int, income int) float64 {
    var res float64

    for idx, b := range brackets {
        tmp := min(income, b[0])

        if idx == 0 {
            res += (float64) (tmp * b[1]) / 100
        } else {
            res += (float64) ((tmp - brackets[idx - 1][0]) * b[1]) / 100
        }

        if income <= b[0] {
            break
        }
    }

    return res
}

func min(a, b int) int {
    if a > b {
        return b
    }

    return a
}