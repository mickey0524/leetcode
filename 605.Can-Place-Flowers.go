// https://leetcode.com/problems/can-place-flowers/
//
// algorithms
// Easy (30.47%)
// Total Accepted:    49,231
// Total Submissions: 161,578
// beats 100.0% of golang submissions

package leetcode

func canPlaceFlowers(flowerbed []int, n int) bool {
	if n == 0 {
		return true
	}

	length := len(flowerbed)

	for i := 0; i < length; i++ {
		if flowerbed[i] == 1 {
			continue
		}
		if i > 0 && flowerbed[i-1] == 1 {
			continue
		}
		if i < length-1 && flowerbed[i+1] == 1 {
			continue
		}
		flowerbed[i] = 1
		n--
		if n == 0 {
			return true
		}
	}

	return false
}
