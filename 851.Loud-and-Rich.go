// https://leetcode.com/problems/loud-and-rich/
//
// algorithms
// Medium (46.23%)
// Total Accepted:    6,223
// Total Submissions: 13,461
// beats 100.0% of golang submissions

type leastStruct struct {
	value int
	index int
}

var res []leastStruct
var isVisited []bool

func loudAndRich(richer [][]int, quiet []int) []int {
	personLen := len(quiet)
	graph := make(map[int][]int)

	for _, r := range richer {
		if arr, ok := graph[r[1]]; ok {
			graph[r[1]] = append(arr, r[0])
		} else {
			graph[r[1]] = []int{r[0]}
		}
	}

	res = make([]leastStruct, personLen)
	isVisited = make([]bool, personLen)

	for i := 0; i < personLen; i++ {
		if !isVisited[i] {
			if _, ok := graph[i]; !ok {
				res[i] = leastStruct{
					value: quiet[i],
					index: i,
				}
				continue
			}
			dfs(graph, quiet, i)
		}
	}

	resIdx := make([]int, personLen)
	for i := 0; i < personLen; i++ {
		resIdx[i] = res[i].index
	}

	return resIdx
}

func dfs(graph map[int][]int, quiet []int, person int) {
	if isVisited[person] {
		return
	}
	isVisited[person] = true

	leastQuiet := quiet[person]
	leastQuietIdx := person

	if arr, ok := graph[person]; ok {
		for _, idx := range arr {
			if !isVisited[idx] {
				dfs(graph, quiet, idx)
			}
			if res[idx].value < leastQuiet {
				leastQuiet = res[idx].value
				leastQuietIdx = res[idx].index
			}
		}
	}

	res[person] = leastStruct{
		value: leastQuiet,
		index: leastQuietIdx,
	}
}
