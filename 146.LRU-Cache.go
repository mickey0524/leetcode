// https://leetcode.com/problems/lru-cache/description/
//
// algorithms
// Hard (21.79%)
// Total Accepted:    213.9k
// Total Submissions: 981.7k
// beats 57.38% of golang submissions

package leetcode

import "container/list"

type LRUCacheIdx struct {
	value   int
	pointer *list.Element
}

type LRUCache struct {
	index     map[int]*LRUCacheIdx
	cacheList *list.List
	capacity  int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		index:     make(map[int]*LRUCacheIdx),
		cacheList: list.New(),
		capacity:  capacity,
	}
}

func (this *LRUCache) Get(key int) int {
	if idx, ok := this.index[key]; ok {
		this.cacheList.MoveToBack(idx.pointer)
		return idx.value
	}

	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if idx, ok := this.index[key]; ok {
		idx.value = value
		this.cacheList.MoveToBack(idx.pointer)
		return
	}

	if this.cacheList.Len() == this.capacity {
		frontPtr := this.cacheList.Front()
		removeKey := frontPtr.Value.(int)
		this.cacheList.Remove(frontPtr)
		delete(this.index, removeKey)
	}

	this.index[key] = &LRUCacheIdx{
		value:   value,
		pointer: this.cacheList.PushBack(key),
	}

	return
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
