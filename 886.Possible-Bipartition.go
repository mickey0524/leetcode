// https://leetcode.com/problems/possible-bipartition/
//
// algorithms
// Medium (39.41%)
// Total Accepted:    9,013
// Total Submissions: 22,896
// ac 之后想了一下，数组开大了，影响了空间复杂度，只需要建立 dislike 的点
// 就行，没必要存在 0 的点，这是可以改进的地方

package leetcode

fvar group = new([]int)
var graph [][]int
var res bool
var isVisited = new([]bool)

func possibleBipartition(N int, dislikes [][]int) bool {
    if N < 2 || len(dislikes) == 0 {
        return true
    }
    
    graph = make([][]int, N+1)
    for i := 0; i <= N; i++ {
        graph[i] = make([]int, N+1)
    }
    
    for _, dislike := range dislikes {
        graph[dislike[0]][dislike[1]] = 1
        graph[dislike[1]][dislike[0]] = 1
    }
    
    *group = make([]int, N+1)
    *isVisited = make([]bool, N+1)
    
    res = true
    
    for i := 1; i <= N; i++ {
        (*group)[i] = 1
        if !(*isVisited)[i] {
            resursive(i, N)
        }
    }
    
    return res
}

func resursive(index, N int) {
    if !res {
        return
    }
    
    (*isVisited)[index] = true
    
    for i := 1; i <= N; i++ {
        if graph[index][i] == 1 {
            if (*isVisited)[i] {
                if (*group)[index] == (*group)[i] {
                    res = false
                    return
                }
            } else {
                (*group)[i] = -(*group)[index]
                resursive(i, N)
            }
        }
    }    
}
