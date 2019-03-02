// https://leetcode.com/problems/range-sum-query-immutable/
//
// algorithms
// Easy (36.63%)
// Total Accepted:    127,419
// Total Submissions: 347,869
// beats 100.0% of golang submissions

package leetcode

type NumArray struct {
	nums []int
}

func Constructor(nums []int) NumArray {
	nums = append([]int{0}, nums...)

	for i := 1; i < len(nums); i++ {
		nums[i] += nums[i-1]
	}

	return NumArray{
		nums: nums,
	}
}

func (this *NumArray) SumRange(i int, j int) int {
	return this.nums[j+1] - this.nums[i]
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
