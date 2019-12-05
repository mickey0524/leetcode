// https://leetcode.com/problems/design-hashset/
//
// algorithms
// Easy (57.08%)
// Total Accepted: 32,658
// Total Submissions: 57,210
// beats 100.0% of java submissions
// 用位图做更好，或者直接自己搞个位图，用 byte 数组

class MyHashSet {

    private boolean[] hashSet;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashSet = new boolean[1000001];
    }

    public void add(int key) {
        this.hashSet[key] = true;
    }

    public void remove(int key) {
        this.hashSet[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */