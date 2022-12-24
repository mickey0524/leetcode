// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
// algorithms
// Medium (58.1%)
// Total Accepted: 19K
// Total Submissions: 32.7K

package leetcode

func dividePlayers(skill []int) int64 {
	sort.Ints(skill)

	length := len(skill)
	i, j := 0, length-1
	curSkill := skill[i] + skill[j]
	var res int

	for i < j {
		tmp := skill[i] + skill[j]
		if curSkill != tmp {
			return -1
		}
		
		res += skill[i] * skill[j]
        i += 1
        j -= 1
	}

	return int64(res)
}
