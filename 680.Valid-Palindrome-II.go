// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
//
// algorithms
// Easy (32.5%)
// Total Accepted:    44.6k
// Total Submissions: 137.2k
// beats 100.0% of golang submissions
// 这道题是求回文数，那么我们可以用两个pointer从string的头和尾巴进行遍历，因为可以删除一个char，因此碰到不相等的char
// 则将tail与head+1、tail-1与head进行比较，如果相等，则删去当前char，需要注意的是，有可能两个比较都是相等的，需要考虑
// 代码isDelete变量有3中取值，0代表没有删除过，1代表删除了，下次再不同就false，2代表删除的时候两种比较都是true，当一种
// 后续遍历失败了的时候，需要back回来再次遍历，否则容易忽略情况，第一次wa就是因为这个
package leetcode

func validPalindrome(s string) bool {
	length := len(s)
	if length < 3 {
		return true
	}

	head, tail, isDelete := 0, length-1, 0
	backHead, backTail := -1, -1
	for {
		if head >= tail {
			break
		}
		if s[head] != s[tail] {
			if isDelete == 0 {
				if s[head+1] == s[tail] && s[head] == s[tail-1] {
					isDelete = 2
					backHead = head
					backTail = tail - 1
					head++
				} else if s[head+1] == s[tail] {
					head++
					isDelete = 1
				} else if s[head] == s[tail-1] {
					isDelete = 1
					tail--
				} else {
					return false
				}
			} else if isDelete == 1 {
				return false
			} else {
				isDelete = 1
				head = backHead
				tail = backTail
			}
		}
		head++
		tail--
	}

	return true
}
