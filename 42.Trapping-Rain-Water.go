// https://leetcode.com/problems/trapping-rain-water/
//
// algorithms
// Hard (43.11%)
// Total Accepted:    290,982
// Total Submissions: 674,901
// beats 100.0% of golang submissions

package leetcode

type tuple struct {
	h   int
	idx int
}

func trap(height []int) int {
	length := len(height)

	var stack []*tuple
	var res int

	for i := 0; i < length; i++ {
		stackLen := len(stack)
		for stackLen > 0 {
			if height[i] > stack[stackLen-1].h {
				pre := stack[stackLen-1].h
				stackLen--
				stack = stack[:stackLen]
				if stackLen > 0 {
					minH := min(height[i], stack[stackLen-1].h)
					res += (minH - pre) * (i - stack[stackLen-1].idx - 1)
				}
			} else {
				break
			}
		}
		stack = append(stack, &tuple{
			h:   height[i],
			idx: i,
		})
	}

	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
