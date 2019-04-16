// https://leetcode.com/problems/online-stock-span/description/
//
// algorithms
// Medium (46.99%)
// Total Accepted:    8,279
// Total Submissions: 17,616
// beats 100.0% of golang submissions

package leetcode

type continuousNum struct {
	length int
	idx    int
	value  int
}

type RLEIterator struct {
	cNumArr []*continuousNum
	idx     int
}

func Constructor(A []int) RLEIterator {
	length := len(A)
	if length == 0 {
		return RLEIterator{}
	}

	iter := RLEIterator{}

	for i := 0; i < length; i += 2 {
		if A[i] > 0 {
			iter.cNumArr = append(iter.cNumArr, &continuousNum{
				length: A[i],
				value:  A[i+1],
			})
		}
	}

	return iter
}

func (this *RLEIterator) Next(n int) int {
	length := len(this.cNumArr)
	if this.idx == length {
		return -1
	}

	for this.idx < length && n > 0 {
		cntNRemain := this.cNumArr[this.idx].length - this.cNumArr[this.idx].idx
		if cntNRemain < n {
			n -= cntNRemain
			this.idx++
		} else if cntNRemain == n {
			res := this.cNumArr[this.idx].value
			this.idx++
			return res
		} else {
			res := this.cNumArr[this.idx].value
			this.cNumArr[this.idx].idx += n
			return res
		}
	}

	return -1
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * obj := Constructor(A);
 * param_1 := obj.Next(n);
 */
