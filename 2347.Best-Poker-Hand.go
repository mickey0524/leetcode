// https://leetcode.com/problems/best-poker-hand/
// algorithms
// Easy (77.26%)
// Total Accepted: 16,330
// Total Submissions: 21,136

package leetcode

func bestHand(ranks []int, suits []byte) string {
	if isFlush(suits) {
		return "Flush"
	}

	rankMap := ranksToMap(ranks)
	maxFreq := 1
	for _, v := range rankMap {
		if v > maxFreq {
			maxFreq = v
		}
	}

	if maxFreq >= 3 {
		return "Three of a Kind"
	} else if maxFreq == 2 {
		return "Pair"
	}

	return "High Card"
}

func isFlush(suits []byte) bool {
	suit := suits[0]

	for _, s := range suits {
		if s != suit {
			return false
		}
	}

	return true
}

func ranksToMap(ranks []int) map[int]int {
	rankMap := make(map[int]int)

	for _, r := range ranks {
		v, ok := rankMap[r]
		if ok {
			rankMap[r] = v + 1
		} else {
			rankMap[r] = 1
		}
	}

	return rankMap
}