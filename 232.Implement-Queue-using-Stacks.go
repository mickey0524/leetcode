// https://leetcode.com/problems/implement-queue-using-stacks/
//
// algorithms
// Easy (43.76%)
// Total Accepted:    153,852
// Total Submissions: 351,599
// beats 100.0% of golang submissions

package leetcode

type MyQueue struct {
	s1 []int
	s2 []int
}

/** Initialize your data structure here. */
func Constructor() MyQueue {
	return MyQueue{}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.s1 = append(this.s1, x)
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	return this.PopOrPeek(true)
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	return this.PopOrPeek(false)
}

func (this *MyQueue) PopOrPeek(isPop bool) int {
	if len(this.s2) == 0 {
		length := len(this.s1)
		for length > 0 {
			this.s2 = append(this.s2, this.s1[length-1])
			length--
			this.s1 = this.s1[:length]
		}
	}

	res := this.s2[len(this.s2)-1]
	if isPop {
		this.s2 = this.s2[:len(this.s2)-1]
	}

	return res
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.s1)+len(this.s2) == 0
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
