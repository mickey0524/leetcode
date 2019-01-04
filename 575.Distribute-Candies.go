// https://leetcode.com/problems/distribute-candies/
//
// algorithms
// Easy (58.72%)
// Total Accepted:    62,276
// Total Submissions: 106,059

package leetcode

func distributeCandies(candies []int) int {
	length := len(candies)
	cntKind := 0
	threshold := length / 2

	hashMap := make(map[int]bool)

	for _, c := range candies {
		if cntKind == threshold {
			return threshold
		}
		if _, ok := hashMap[c]; !ok {
			hashMap[c] = true
			cntKind++
		}
	}

	return cntKind
}
