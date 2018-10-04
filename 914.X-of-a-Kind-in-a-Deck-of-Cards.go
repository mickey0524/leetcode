// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
//
// algorithms
// Easy (33.08%)
// Total Accepted:    4.3k
// Total Submissions: 13k
// beats 100.0% of golang submissions
// 这道题首先需要得到slice中每个元素的个数，然后从2开始，直到slice的最小值
// 如果map的value都能够整除base，那么说明能够按照X=base进行split，否则，当
// base > min的时候，就不需要继续寻找了，肯定没有合适的X

package leetcode

func hasGroupsSizeX(deck []int) bool {
	cardMap := make(map[int]int)
	length := len(deck)
	if length == 1 {
		return false
	}

	for _, n := range deck {
		cntNum, ok := cardMap[n]
		if ok {
			cardMap[n] = cntNum + 1
		} else {
			cardMap[n] = 1
		}
	}

	minCard := int(^uint(0) >> 1)
	for _, v := range cardMap {
		if v < minCard {
			minCard = v
		}
	}

	for base := 2; base <= minCard; base++ {
		isFound := true
		for _, v := range cardMap {
			if v%base != 0 {
				isFound = false
				break
			}
		}
		if isFound {
			return true
		}
	}

	return false
}
