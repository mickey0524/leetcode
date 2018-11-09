// https://leetcode.com/problems/partition-equal-subset-sum/description/
//
// algorithms
// Medium (38.87%)
// Total Accepted:    61.3k
// Total Submissions: 157.7k
// beats 70.83% of golang submissions

package leetcode

var hashMap map[point]bool

type point struct {
	idx    int
	cntSum int
}

func canPartition(nums []int) bool {
	numsSum := 0
	for _, n := range nums {
		numsSum += n
	}

	if numsSum%2 == 1 {
		return false
	}

	hashMap = make(map[point]bool)

	return resursive(nums, len(nums), 0, 0, numsSum>>1)
}

func resursive(nums []int, length, cntSum, idx, numsSum int) bool {
	if cntSum == numsSum {
		return true
	}

	if cntSum > numsSum || idx == length {
		return false
	}

	for i := idx; i < length; i++ {
		p := point{
			idx:    i,
			cntSum: cntSum,
		}
		if _, ok := hashMap[p]; ok {
			continue
		}
		if resursive(nums, length, cntSum+nums[i], i+1, numsSum) {
			return true
		}
		hashMap[point{
			idx:    i,
			cntSum: cntSum,
		}] = true
	}

	return false
}

// 其实递归就能做，最好的做法

func canPartition(nums []int) bool {
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if sum%2 == 1 {
		return false
	}
	// sum=sum/2
	return helperPartition(nums, 0, 0, len(nums)-1, sum)
}

func helperPartition(nums []int, sum1, sum2, pos, total int) bool {
	if sum2 > total/2 || sum1 > total/2 {
		return false
	}
	if sum1 == total/2 {
		return pos >= -1
	}
	return helperPartition(nums, sum1+nums[pos], sum2, pos-1, total) || helperPartition(nums, sum1, sum2+nums[pos], pos-1, total)
}
