// https://leetcode.com/problems/design-circular-queue/description/
//
// algorithms
// Medium (36.36%)
// Total Accepted:    7.2k
// Total Submissions: 19.8k
// beats 100.0% of golang submissions

package leetcode

type MyCircularQueue struct {
	queue   []int
	size    int
	cntSize int
}

/** Initialize your data structure here. Set the size of the queue to be k. */
func Constructor(k int) MyCircularQueue {
	return MyCircularQueue{
		size: k,
	}
}

/** Insert an element into the circular queue. Return true if the operation is successful. */
func (this *MyCircularQueue) EnQueue(value int) bool {
	if this.cntSize == this.size {
		return false
	}
	this.queue = append(this.queue, value)
	this.cntSize++
	return true
}

/** Delete an element from the circular queue. Return true if the operation is successful. */
func (this *MyCircularQueue) DeQueue() bool {
	if this.cntSize == 0 {
		return false
	}
	this.queue = this.queue[1:]
	this.cntSize--
	return true
}

/** Get the front item from the queue. */
func (this *MyCircularQueue) Front() int {
	if this.cntSize == 0 {
		return -1
	}
	return this.queue[0]
}

/** Get the last item from the queue. */
func (this *MyCircularQueue) Rear() int {
	if this.cntSize == 0 {
		return -1
	}
	return this.queue[this.cntSize-1]
}

/** Checks whether the circular queue is empty or not. */
func (this *MyCircularQueue) IsEmpty() bool {
	return this.cntSize == 0
}

/** Checks whether the circular queue is full or not. */
func (this *MyCircularQueue) IsFull() bool {
	return this.cntSize == this.size
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.EnQueue(value);
 * param_2 := obj.DeQueue();
 * param_3 := obj.Front();
 * param_4 := obj.Rear();
 * param_5 := obj.IsEmpty();
 * param_6 := obj.IsFull();
 */
