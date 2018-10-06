// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
//
// algorithms
// Medium (48.8%)
// Total Accepted:    2.2k
// Total Submissions: 4.5k
// beats 100.0% of golang submissions

package leetcode

type MyCircularDeque struct {
	queue   []int
	cntSize int
	size    int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{
		size: k,
	}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.cntSize == this.size {
		return false
	}
	this.cntSize++
	this.queue = append([]int{value}, this.queue...)
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.cntSize == this.size {
		return false
	}
	this.cntSize++
	this.queue = append(this.queue, value)
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.cntSize == 0 {
		return false
	}
	this.cntSize--
	this.queue = this.queue[1:]
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.cntSize == 0 {
		return false
	}
	this.cntSize--
	this.queue = this.queue[:this.cntSize]
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.cntSize == 0 {
		return -1
	}
	return this.queue[0]
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.cntSize == 0 {
		return -1
	}
	return this.queue[this.cntSize-1]
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.cntSize == 0
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.cntSize == this.size
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
