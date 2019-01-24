// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
//
// algorithms
// Medium (47.47%)
// Total Accepted:    18,150
// Total Submissions: 38,238
// beats 100.0% of golang submissions

package leetcode

var res int

func shoppingOffers(price []int, special [][]int, needs []int) int {
	var specialCanUse [][]int
	length := len(needs)

canUse:
	for _, l := range special {
		s := 0
		for i := 0; i < length; i++ {
			if l[i] > needs[i] {
				continue canUse
			}
			s += price[i] * l[i]
		}
		if s > l[length] {
			specialCanUse = append(specialCanUse, l)
		}
	}

	res = 0
	for idx, n := range needs {
		res += n * price[idx]
	}

	recursive(price, specialCanUse, needs, 0)

	return res
}

func recursive(price []int, special [][]int, needs []int, cnt int) {
	if cnt >= res {
		return
	}

	length := len(needs)

	for _, l := range special {
		canUseSpecial := true
		for i := 0; i < length; i++ {
			if needs[i] < l[i] {
				canUseSpecial = false
				break
			}
		}
		if canUseSpecial {
			tmp := make([]int, length)
			copy(tmp, needs)
			for i := 0; i < length; i++ {
				needs[i] -= l[i]
			}
			recursive(price, special, needs, cnt+l[length])
			needs = tmp
		}
	}

	for i := 0; i < length; i++ {
		cnt += needs[i] * price[i]
		if cnt >= res {
			return
		}
	}

	res = min(res, cnt)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
