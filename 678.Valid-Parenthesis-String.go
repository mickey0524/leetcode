// https://leetcode.com/problems/valid-parenthesis-string/description/
//
// algorithms
// Easy (30.65%)
// Total Accepted:    18.3k
// Total Submissions: 59.7k
// beats 100.0% of golang submissions

package leetcode

func checkValidString(s string) bool {
	stack := []rune{}
	for _, ch := range s {
		stackLen := len(stack)
		if stackLen == 0 {
			stack = append(stack, ch)
		} else if ch == '(' || ch == '*' {
			stack = append([]rune{ch}, stack...)
		} else {
			if stack[0] == '(' {
				stack = stack[1:]
			} else if stack[0] == '*' {
				idx := 1
				for ; idx < stackLen; idx++ {
					if stack[idx] == '(' {
						break
					}
				}
				if idx == stackLen {
					stack = stack[1:]
				} else {
					stack = append(stack[:idx], stack[idx+1:]...)
				}
			} else {
				stack = append([]rune{ch}, stack...)
			}
		}
	}

	length := len(stack)
	for i, j := 0, length-1; i < j; i, j = i+1, j-1 {
		stack[i], stack[j] = stack[j], stack[i]
	}
	starIdx := -1

	for idx, ch := range stack {
		if ch == ')' {
			return false
		} else if ch == '(' {
			i := maxInt(idx+1, starIdx)
			for ; i < length; i++ {
				if stack[i] == '*' {
					starIdx = i + 1
					break
				}
			}
			if i == length {
				return false
			}
		}
	}

	return true
}

func maxInt(x, y int) int {
	if x > y {
		return x
	}
	return y
}

// 这是比较简单的解法
func checkValidString(S string) bool {
	left := 0
	for i := 0; i < len(S); i++ {
		if S[i] == '(' || S[i] == '*' {
			left += 1
		} else {
			left -= 1
		}
		if left < 0 {
			return false
		}
	}
	right := 0
	for i := len(S) - 1; i >= 0; i-- {
		if S[i] == ')' || S[i] == '*' {
			right += 1
		} else {
			right -= 1
		}
		if right < 0 {
			return false
		}
	}
	return true
}
