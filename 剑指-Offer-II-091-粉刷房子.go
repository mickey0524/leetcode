// https://leetcode.cn/problems/JEj789/
//
// algorithms
// Medium (77.82%)
// Total Accepted:    24,166
// Total Submissions: 31,054

package leetcode

func minCost(costs [][]int) int {
    len := len(costs)

    r, g, b := costs[0][0], costs[0][1], costs[0][2]
    for i := 1; i < len; i++ {
        rTmp := costs[i][0] + min([]int{g, b})
        gTmp := costs[i][1] + min([]int{r, b})
        bTmp := costs[i][2] + min([]int{r, g})

        r, g, b = rTmp, gTmp, bTmp
    }

    return min([]int{r, g, b})
}

func min(arr []int) int {
    len := len(arr)
    if len < 1 {
        return 0
    }

    res := arr[0]
    for i := 1; i < len; i++ {
        if arr[i] < res {
            res = arr[i]
        }
    }

    return res
}
