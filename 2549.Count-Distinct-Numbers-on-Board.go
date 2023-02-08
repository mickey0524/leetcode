// https://leetcode.com/problems/count-distinct-numbers-on-board/description/
// Easy (59.28%)
// Total Accepted: 23K
// Total Submissions: 38.8K

func distinctIntegers(n int) int {
	res := 1

	q := []int{n}
	memMap := make(map[int]int8)
	for len(q) > 0 {
		curN := q[0]
		tmp := curN - 1

		if tmp > 1 && memMap[tmp] == 0 {
			res++
			q = append(q, tmp)
			memMap[tmp] = 1
			for i := 2; i <= int(math.Sqrt(float64(tmp))); i++ {
				if tmp%i == 0 && memMap[i] == 0 {
					q = append(q, i)
					memMap[i] = 1
					res++
				}
			}
		}

		q = q[1:]
	}

	return res
}