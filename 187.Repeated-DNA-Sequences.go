// https://leetcode.com/problems/repeated-dna-sequences/
//
// algorithms
// Medium (34.83%)
// Total Accepted:    112,974
// Total Submissions: 324,368
// beats 93.33% of golang submissions

package leetcode

func findRepeatedDnaSequences(s string) []string {
	length := len(s)

	var res []string

	if length < 10 {
		return res
	}

	hashMap := make(map[string]int)

	for i := 0; i < length-9; i++ {
		if time, ok := hashMap[s[i:i+10]]; ok {
			if time == 1 {
				res = append(res, s[i:i+10])
				hashMap[s[i:i+10]] = 2
			}
		} else {
			hashMap[s[i:i+10]] = 1
		}
	}

	return res
}
