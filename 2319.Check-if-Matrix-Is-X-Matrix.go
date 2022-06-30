// https://leetcode.com/problems/check-if-matrix-is-x-matrix/
// algorithms
// Easy (67.12%)
// Total Accepted: 19.6K
// Total Submissions: 29.2K

package leetcode

func checkXMatrix(grid [][]int) bool {
    len := len(grid)
    
    for i := 0; i < len; i++ {
        for j := 0; j < len; j++ {
            if i == j || i + j == len - 1 {
                if grid[i][j] == 0 {
                    return false
                }
            } else {
                if grid[i][j] != 0 {
                    return false
                }
            }
        }
    }
    
    
    return true
}