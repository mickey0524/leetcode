// https://leetcode.com/problems/broken-calculator/
//
// algorithms
// Medium (32.38%)
// Total Accepted:    1,895
// Total Submissions: 5,852
// beats 100.0% of golang submissions
// 这道题其实是一个数学题，当 X >= Y 的时候，如果想要 X -> Y，只能将 X 递减至 Y
// 当 X < Y 的时候，我们换个角度想，如何将 Y 变为 X，对于 Y 来说，只有两个操作
// Y -> Y + 1 or Y -> Y / 2，当 Y 为奇数的时候，只能 Y -> Y + 1，为偶数的时候
// 选用 Y -> Y / 2

package leetcode

func brokenCalc(X int, Y int) int {
	if X >= Y {
		return X - Y
	}
	return 1 + Y%2 + brokenCalc(X, (Y+1)/2)
}
