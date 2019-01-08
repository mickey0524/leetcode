// https://leetcode.com/problems/ransom-note/
//
// algorithms
// Medium (48.96%)
// Total Accepted:    99,221
// Total Submissions: 202,642
// beats 62.16% of golang submissions

package leetcode

func canConstruct(ransomNote string, magazine string) bool {
	hashMapNote, hashMapMagazine := make(map[rune]int), make(map[rune]int)

	for _, ch := range ransomNote {
		if v, ok := hashMapNote[ch]; ok {
			hashMapNote[ch] = v + 1
		} else {
			hashMapNote[ch] = 1
		}
	}

	for _, ch := range magazine {
		if v, ok := hashMapMagazine[ch]; ok {
			hashMapMagazine[ch] = v + 1
		} else {
			hashMapMagazine[ch] = 1
		}
	}

	for k, v := range hashMapNote {
		if v1, ok := hashMapMagazine[k]; !ok || v1 < v {
			return false
		}
	}

	return true
}
