// https://leetcode.com/problems/evaluate-division/description/
//
// algorithms
// Medium (43.63%)
// Total Accepted:    44.9k
// Total Submissions: 102.9k
// beats 100.0% of golang submissions
// 这道题的关键在于把问题抽象化为graph，然后就是简单的dfs了

package leetcode

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	paramMap, cntIdx := make(map[string]int), 0

	for _, equation := range equations {
		for i := 0; i < 2; i++ {
			if _, ok := paramMap[equation[i]]; !ok {
				paramMap[equation[i]] = cntIdx
				cntIdx++
			}
		}
	}

	graph := make([][]float64, cntIdx)
	for i := 0; i < cntIdx; i++ {
		graph[i] = make([]float64, cntIdx)
	}

	equationLen := len(equations)
	for i := 0; i < equationLen; i++ {
		x, y := paramMap[equations[i][0]], paramMap[equations[i][1]]
		graph[x][y] = values[i]
		graph[y][x] = 1 / values[i]
	}

	queryLen := len(queries)
	res := make([]float64, queryLen)
	for idx, query := range queries {
		start, end := getMapKey(paramMap, query[0]), getMapKey(paramMap, query[1])
		if start == -1 || end == -1 {
			res[idx] = -1.0
		} else {
			isVisited := make([]bool, cntIdx)
			res[idx] = dfsGraph(graph, start, end, 1.0, isVisited)
		}
	}

	return res
}

func getMapKey(m map[string]int, k string) int {
	if v, ok := m[k]; ok {
		return v
	}
	return -1
}

func dfsGraph(graph [][]float64, start int, end int, multiply float64, isVisited []bool) float64 {
	isVisited[start] = true
	if graph[start][end] > 0 {
		return multiply * graph[start][end]
	}
	for idx, n := range graph[start] {
		if n > 0 && !isVisited[idx] {
			res := dfsGraph(graph, idx, end, multiply*n, isVisited)
			if res != -1.0 {
				return res
			}
		}
	}
	return -1.0
}
