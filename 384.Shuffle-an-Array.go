// https://leetcode.com/problems/shuffle-an-array/
//
// algorithms
// Medium (48.9%)
// Total Accepted:    62,460
// Total Submissions: 127,700
// beats 90.48% of golang submissions

package leetcode

import "math/rand"

type Solution struct {
	initNums []int
}

func Constructor(nums []int) Solution {
	return Solution{
		initNums: nums,
	}
}

/** Resets the array to its original configuration and return it. */
func (this *Solution) Reset() []int {
	return this.initNums
}

/** Returns a random shuffling of the array. */
func (this *Solution) Shuffle() []int {
	length := len(this.initNums)
	shuffleNums := make([]int, length)
	copy(shuffleNums, this.initNums)

	for i := length - 1; i >= 0; i-- {
		idx := rand.Intn(i + 1)
		shuffleNums[i], shuffleNums[idx] = shuffleNums[idx], shuffleNums[i]
	}

	return shuffleNums
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Reset();
 * param_2 := obj.Shuffle();
 */
