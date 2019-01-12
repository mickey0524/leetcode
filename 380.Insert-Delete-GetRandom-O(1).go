// https://leetcode.com/problems/insert-delete-getrandom-o1/
//
// algorithms
// Medium (41.59%)
// Total Accepted:    91,636
// Total Submissions: 220,336
// beats 100.0% of golang submissions

package leetcode

import "math/rand"

type RandomizedSet struct {
	hashMap map[int]int
	arr     []int
}

/** Initialize your data structure here. */
func Constructor() RandomizedSet {
	return RandomizedSet{
		hashMap: make(map[int]int),
	}
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.hashMap[val]; ok {
		return false
	}
	this.hashMap[val] = len(this.arr)
	this.arr = append(this.arr, val)
	return true
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
func (this *RandomizedSet) Remove(val int) bool {
	idx, ok := this.hashMap[val]
	if !ok {
		return false
	}
	length := len(this.arr)
	this.arr[idx], this.arr[length-1] = this.arr[length-1], this.arr[idx]
	this.hashMap[this.arr[idx]] = idx
	delete(this.hashMap, this.arr[length-1])
	this.arr = this.arr[:length-1]
	return true
}

/** Get a random element from the set. */
func (this *RandomizedSet) GetRandom() int {
	if len(this.arr) == 0 {
		return -1
	}
	return this.arr[rand.Intn(len(this.arr))]
}
