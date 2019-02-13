// https://leetcode.com/problems/random-pick-with-weight/
//
// algorithms
// Medium (42.52%)
// Total Accepted:    16,580
// Total Submissions: 38,993
// beats 100.0% of golang submissions

package leetcode

import "math/rand"

type Solution struct {
	sumWArr []int
}

func Constructor(w []int) Solution {
	var sumWArr []int
	var sumW int

	for _, n := range w {
		sumW += n
		sumWArr = append(sumWArr, sumW)
	}

	return Solution{
		sumWArr: sumWArr,
	}
}

func (this *Solution) PickIndex() int {
	length := len(this.sumWArr)

	randomW := rand.Intn(this.sumWArr[length-1])

	head, tail, middle := 0, length-1, 0
	for head < tail {
		middle = head + (tail-head)/2
		if this.sumWArr[middle] == randomW {
			return middle + 1
		}
		if this.sumWArr[middle] < randomW {
			head = middle + 1
		} else {
			tail = middle
		}
	}

	return head
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */
