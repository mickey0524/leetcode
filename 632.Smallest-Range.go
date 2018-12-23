// https://leetcode.com/problems/smallest-range/
//
// algorithms
// Hard (45.02%)
// Total Accepted:    17,457
// Total Submissions: 38,772
// beats 100.0% of golang submissions

package main

import "container/heap"

type heapItem struct {
	value int
	i     int
	j     int
	len   int
}

type heapArr []*heapItem

func (h heapArr) Len() int           { return len(h) }
func (h heapArr) Less(i, j int) bool { return h[i].value < h[j].value }
func (h heapArr) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *heapArr) Push(val interface{}) {
	item := val.(*heapItem)
	*h = append(*h, item)
}
func (h *heapArr) Pop() interface{} {
	n := len(*h)
	item := (*h)[n-1]
	*h = (*h)[:n-1]

	return item
}

func smallestRange(nums [][]int) []int {
	length := len(nums)
	if length == 1 {
		return []int{nums[0][0], nums[0][0]}
	}

	pq := make(heapArr, length)
	max, min := nums[0][0], nums[0][0]
	for i := 0; i < length; i++ {
		pq[i] = &heapItem{
			value: nums[i][0],
			i:     i,
			j:     0,
			len:   len(nums[i]),
		}
		if nums[i][0] > max {
			max = nums[i][0]
		} else if nums[i][0] < min {
			min = nums[i][0]
		}
	}

	heap.Init(&pq)
	res := []int{min, max}
	if min == max {
		return res
	}

	for {
		item := heap.Pop(&pq).(*heapItem)
		min := item.value
		if max-min < res[1]-res[0] {
			res[1], res[0] = max, min
		}

		if item.j+1 == item.len {
			break
		}

		newItem := &heapItem{
			value: nums[item.i][item.j+1],
			i:     item.i,
			j:     item.j + 1,
			len:   item.len,
		}

		if newItem.value > max {
			max = newItem.value
		}

		heap.Push(&pq, newItem)
	}

	return res
}
