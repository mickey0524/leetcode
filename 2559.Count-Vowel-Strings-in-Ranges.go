// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
// Medium (50.8%)
// Total Accepted: 17.9K
// Total Submissions: 35.1K


func vowelStrings(words []string, queries [][]int) []int {
	vowelLetterMap := map[uint8]int8{
		'a': 1,
		'e': 1,
		'i': 1,
		'o': 1,
		'u': 1,
	}

	queriesLen := len(queries)
	wordsLen := len(words)

	res := make([]int, 0, queriesLen)
	vowelWordNum := make([]int,wordsLen+1)
	vowelWordNum[0] = 0
	for i := 0; i < wordsLen; i++ {
		wordLen := len(words[i])
		if vowelLetterMap[words[i][0]] != 0 && vowelLetterMap[words[i][wordLen-1]] != 0 {
			vowelWordNum[i+1] = vowelWordNum[i] + 1
		} else {
			vowelWordNum[i+1] = vowelWordNum[i]
		}
	}

	for _, q := range queries {
		res = append(res, vowelWordNum[q[1] + 1]-vowelWordNum[q[0]])
	}

	return res
}