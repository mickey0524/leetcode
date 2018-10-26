// https://leetcode.com/problems/spiral-matrix-iii/description/
//
// algorithms
// Medium (62.5%)
// Total Accepted:    4.5k
// Total Submissions: 7.2k
// beats 75.0% of golang submissions

package leetcode

func spiralMatrixIII(R int, C int, r0 int, c0 int) [][]int {
	var res [][]int
	res = append(res, []int{r0, c0})
	length := R * C
	if length == 1 {
		return res
	}

	cntStep, cntNum := 1, 1

	for {
		cntNum = traverse(&r0, &c0, cntStep, 1, -1, R, C, &res) + cntNum
		if cntNum == length {
			break
		}
		cntNum = traverse(&r0, &c0, cntStep, 1, 1, R, C, &res) + cntNum
		if cntNum == length {
			break
		}
		cntStep++
		cntNum = traverse(&r0, &c0, cntStep, -1, -1, R, C, &res) + cntNum
		if cntNum == length {
			break
		}
		cntNum = traverse(&r0, &c0, cntStep, -1, 1, R, C, &res) + cntNum
		if cntNum == length {
			break
		}
		cntStep++
	}

	return res
}

func traverse(r, c *int, step, base, dir, R, C int, res *[][]int) int {
	num := 0

	for i := 0; i < step; i++ {
		if dir == 1 {
			*r = *r + base
		} else {
			*c = *c + base
		}
		if *r < R && *c < C && *r >= 0 && *c >= 0 {
			*res = append(*res, []int{*r, *c})
			num++
		}
	}

	return num
}
