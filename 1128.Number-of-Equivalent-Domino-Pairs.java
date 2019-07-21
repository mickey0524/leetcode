// https://leetcode.com/problems/number-of-equivalent-domino-pairs/
//
// algorithms
// Easy (35.04%)
// Total Accepted: 2,906
// Total Submissions: 8,294
// beats 100.0% of java submissions


class Tuple2 {
    public int field1;
    public int field2;
    
    public Tuple2(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Tuple2 t = (Tuple2) o;
        
        return this.field1 == t.field1 && this.field2 == t.field2;
    }
    
    public int hashCode() {
        return field1 ^ field2;
    }
}

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Tuple2, Integer> hashMap = new HashMap<>();
        
        for (int[] pair : dominoes) {
            int more = Math.max(pair[0], pair[1]);
            int less = Math.min(pair[0], pair[1]);
            
            Tuple2 t = new Tuple2(more, less);
            
            hashMap.put(t, hashMap.getOrDefault(t, 0) + 1);
        }
        
        int res = 0;
        
        for (int n : hashMap.values()) {
            res += getFactorial(n);
        }
        
        return res;
    }
    
    public int getFactorial(int n) {
        int res = 0;
        
        for (int i = 1; i < n; i++) {
            res += i;
        }
        
        return res;
    }
}