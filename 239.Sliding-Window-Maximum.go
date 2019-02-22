// https://leetcode.com/problems/sliding-window-maximum/
//
// algorithms
// Hard (36.95%)
// Total Accepted:    136,051
// Total Submissions: 368,189
// beats 100.0% of golang submissions

// 暴力 O(kn) 的方法就不讲了
// 这是采用 queue 的方式，将索引入数组，当其比数组末尾的索引对应的元素大的时候，将末尾索引出队列
// 因为题目要求最大值，待插入的数大于当前末尾值，直接删除即可
package leetcode

func maxSlidingWindow(nums []int, k int) []int {
	length := len(nums)
	var res []int

	if length == 0 {
		return res
	}

	var queue []int
	for i := 0; i < k; i++ {
		queueLen := len(queue)
		for queueLen > 0 {
			if nums[i] > nums[queue[queueLen-1]] {
				queueLen--
				queue = queue[:queueLen]
			} else {
				break
			}
		}
		queue = append(queue, i)
	}

	for i := k; i < length; i++ {
		res = append(res, nums[queue[0]])

		if queue[0] < i-k+1 {
			queue = queue[1:]
		}

		queueLen := len(queue)
		for queueLen > 0 {
			if nums[i] > nums[queue[queueLen-1]] {
				queueLen--
				queue = queue[:queueLen]
			} else {
				break
			}
		}
		queue = append(queue, i)
	}

	res = append(res, nums[queue[0]])

	return res
}
