// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
//
// algorithms
// Medium (48.91%)
// Total Accepted:    3,060
// Total Submissions: 6,256

package leetcode

var sz []int
var par []int
var n int

func union(x, y int) {
	a := find(x)
	b := find(y)
	if a == b {
		return
	}
	if sz[a] > sz[b] {
		sz[a] += sz[b]
		par[b] = a
	} else {
		sz[b] += sz[a]
		par[a] = b
	}
}

func find(x int) int {
	if par[x] == x {
		return x
	}
	return find(par[x])
}

func removeStones(stones [][]int) int {
	n = len(stones)
	sz = make([]int, n)
	par = make([]int, n)
	for i := 0; i < n; i++ {
		sz[i] = 1
		par[i] = i
	}
	mpc := make(map[int]int)
	mpr := make(map[int]int)

	for i := 0; i < n; i++ {
		val, ok := mpr[stones[i][0]]
		if ok {
			union(val, i)
		}
		mpr[stones[i][0]] = i
		val, ok = mpc[stones[i][1]]
		if ok {
			union(val, i)
		}
		mpc[stones[i][1]] = i
	}
	ans := 0
	for i := 0; i < n; i++ {
		if find(i) != i {
			ans++
		}
	}
	return ans

}
