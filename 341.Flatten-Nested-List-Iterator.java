// https://leetcode.com/problems/flatten-nested-list-iterator/
//
// algorithms
// Medium (47.63%)
// Total Accepted:    107,375
// Total Submissions: 225,424


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Integer[] l;
    int i;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        ArrayList<Integer> arr = this.getList(nestedList);
        
        this.l = arr.toArray(new Integer[arr.size()]);
    }

    @Override
    public Integer next() {
        return l[i++];
    }

    @Override
    public boolean hasNext() {
        return i < l.length;
    }
    
    public ArrayList<Integer> getList(List<NestedInteger> nestedList) {
        ArrayList<Integer> l = new ArrayList<>();
        
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                l.add(ni.getInteger());
            } else {
                l.addAll(this.getList(ni.getList()));
            }
        }
        
        return l;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */