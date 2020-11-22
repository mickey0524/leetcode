// https://leetcode.com/problems/design-an-ordered-stream/
// algorithms
// Easy (80.46%)
// Total Accepted: 6,579
// Total Submissions: 8,177
// beats 100.0% of java submissions


class OrderedStream {
    
    private String[] values;
    
    private int ptr;
    
    private int n;

    public OrderedStream(int n) {
        this.values = new String[n + 1];
        this.ptr = 1;
        this.n = n;
    }
    
    public List<String> insert(int id, String value) {
        this.values[id] = value;
        if (id != ptr) {
            return Collections.emptyList();
        }
        
        List<String> res = new ArrayList<>();
        while (ptr <= n && values[ptr] != null) {
            res.add(values[ptr]);
            ptr++;
        }
        
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */