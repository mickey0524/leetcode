// https://leetcode.com/problems/sort-colors/
//
// algorithms
// Easy (42.68%)
// Total Accepted:    279,946
// Total Submissions: 684,500
// beats 40.89% of golang submission

package leetcode

// O(2 * n) 做法

func sortColors(nums []int) {
	flag := make([]int, 3)

	for _, n := range nums {
		flag[n]++
	}

	idx := 0
	len := flag[0]
	for ; idx < len; idx++ {
		nums[idx] = 0
	}
	len += flag[1]
	for ; idx < len; idx++ {
		nums[idx] = 1
	}
	len += flag[2]
	for ; idx < len; idx++ {
		nums[idx] = 2
	}
}

// O(n) 做法

func sortColorsV1(nums []int) {
	red, blue := 0, len(nums)
	for i := 0; red < blue && i < blue; {
		switch nums[i] {
		case 0:
			red++
			if i == red {
				i++
				break
			}
			nums[i], nums[red] = nums[red], nums[i]			
		}
		case 1:
			i++
		case 2:
			blue--
			nums[i], nums[blue] = nums[blue], nums[i]	
	}
}
