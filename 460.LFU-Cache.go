// https://leetcode.com/problems/lfu-cache/description/
//
// algorithms
// Hard (21.79%)
// Total Accepted:    28.3k
// Total Submissions: 107.2k
// beats 26.39% of golang submissions
// 这道题我的思路是每个freq用一个链表存放
// 学习其他人的思路，发现其实lfu和heap特别像，按freq以及顺序构建最小堆应该是更好的做法

package leetcode

import "container/list"

type LFUCacheIdx struct {
	value   int
	freq    int
	pointer *list.Element
}

type LFUCache struct {
	index      map[int]*LFUCacheIdx
	freqList   map[int]*list.List
	cntMinFreq int
	cntCap     int
	capacity   int
}

func Constructor(capacity int) LFUCache {
	return LFUCache{
		index:      make(map[int]*LFUCacheIdx),
		freqList:   make(map[int]*list.List),
		cntMinFreq: 0,
		capacity:   capacity,
	}
}

func (this *LFUCache) Get(key int) int {
	if idx, ok := this.index[key]; ok {
		ptr := idx.pointer
		freq := idx.freq
		idx.freq = freq + 1
		this.freqList[freq].Remove(ptr)

		if cacheList, listExist := this.freqList[freq+1]; listExist {
			idx.pointer = cacheList.PushBack(key)
		} else {
			this.freqList[freq+1] = list.New()
			idx.pointer = this.freqList[freq+1].PushBack(key)
		}

		if freq == this.cntMinFreq && this.freqList[freq].Len() == 0 {
			this.cntMinFreq = freq + 1
		}

		return idx.value
	}

	return -1
}

func (this *LFUCache) Put(key int, value int) {
	if this.capacity == 0 {
		return
	}

	if idx, ok := this.index[key]; ok {
		ptr := idx.pointer
		freq := idx.freq

		// this.cntMinFreq = 0
		this.freqList[freq].Remove(ptr)
		if freq == this.cntMinFreq && this.freqList[freq].Len() == 0 {
			this.cntMinFreq = freq + 1
		}

		// 		idx.pointer = this.freqList[0].PushBack(key)
		idx.freq = freq + 1
		idx.value = value
		if _, ok := this.freqList[freq+1]; !ok {
			this.freqList[freq+1] = list.New()
		}
		idx.pointer = this.freqList[freq+1].PushBack(key)

		return
	}

	if this.cntCap == this.capacity {
		removePtr := this.freqList[this.cntMinFreq].Front()
		removeKey := removePtr.Value.(int)
		this.freqList[this.cntMinFreq].Remove(removePtr)
		delete(this.index, removeKey)
		this.cntCap = this.cntCap - 1
	}

	if cacheList, listExist := this.freqList[0]; listExist {
		this.index[key] = &LFUCacheIdx{
			value:   value,
			freq:    0,
			pointer: cacheList.PushBack(key),
		}
	} else {
		this.freqList[0] = list.New()
		this.index[key] = &LFUCacheIdx{
			value:   value,
			freq:    0,
			pointer: this.freqList[0].PushBack(key),
		}
	}

	this.cntMinFreq = 0
	this.cntCap = this.cntCap + 1

	return
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
