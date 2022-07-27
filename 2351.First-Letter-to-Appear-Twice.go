// https://leetcode.com/problems/first-letter-to-appear-twice/
// algorithms
// Easy (77.26%)
// Total Accepted: 22,707
// Total Submissions: 28,617

package leetcode

func repeatedCharacter(s string) byte {
	chMap := make(map[byte]int)

	for _, ch := range s {
		key := byte(ch)
		_, ok := chMap[key]
		if ok {
			return key
		}

		chMap[key] = 1
	}

	return 0
}