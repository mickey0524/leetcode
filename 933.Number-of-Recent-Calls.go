// https://leetcode.com/problems/number-of-recent-calls/description/
//
// algorithms
// Easy (64.21%)
// Total Accepted:    6.1k
// Total Submissions: 9.5k

package leetcode

type RecentCounter struct {
	queue []int
}

func Constructor() RecentCounter {
	return RecentCounter{
		queue: []int{},
	}
}

func (this *RecentCounter) Ping(t int) int {
	idx, length := 0, len(this.queue)
	for ; idx < length; idx++ {
		if t-this.queue[idx] <= 3000 {
			break
		}
	}
	this.queue = append(this.queue[idx:], t)
	return len(this.queue)
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Ping(t);
 */
