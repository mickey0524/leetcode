// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
//
// algorithms
// Easy (46.8%)
// Total Accepted:    46,868
// Total Submissions: 100,125

package leetcode

func findRestaurant(list1 []string, list2 []string) []string {
	hashMap1, hashMap2 := make(map[string]int), make(map[string]int)

	for idx, s := range list1 {
		hashMap1[s] = idx
	}

	for idx, s := range list2 {
		hashMap2[s] = idx
	}

	res := []string{}
	idxSum := 3000
	for i := 0; i < len(list1); i++ {
		if idx, ok := hashMap2[list1[i]]; ok {
			if idx+i < idxSum {
				idxSum = idx + i
				res = []string{list1[i]}
			} else if idx+i == idxSum {
				res = append(res, list1[i])
			}
		}
	}

	return res
}
