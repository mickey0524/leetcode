// https://leetcode.com/problems/equal-row-and-column-pairs/
// algorithms
// Medium (71.32%)
// Total Accepted: 19,958
// Total Submissions: 27,982

package leetcode

const separator = "#"

func equalPairs(grid [][]int) int {
    rowMap := make(map[string]int)
    n := len(grid)

    for i := 0; i < n; i++ {
        buf := bytes.NewBufferString("")
        for _, num := range grid[i] {
            buf.WriteString(strconv.Itoa(num))
            buf.WriteString(separator)
        }
        
        key := buf.String()
        v, ok := rowMap[key]
        if ok {
            rowMap[key] = v + 1
        } else {
            rowMap[key] = 1
        }
        
    }

    res := 0
    for i := 0; i < n; i++ {
        buf := bytes.NewBufferString("")
        for j := 0; j < n; j++ {
            buf.WriteString(strconv.Itoa(grid[j][i]))
            buf.WriteString(separator)
        }
        key := buf.String()

        if v, ok := rowMap[key]; ok {
            res += v
        }
    }

    return res
}