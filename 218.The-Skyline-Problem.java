// https://leetcode.com/problems/the-skyline-problem/
//
// algorithms
// Hard (31.52%)
// Total Accepted:    90,868
// Total Submissions: 288,256

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<int[]> heights = new ArrayList<>();
        
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(heights, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        q.offer(0);
        int pre = 0;
        
        for (int[] h : heights) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            } else {
                q.remove(h[1]);
            }
            int cur = q.peek();
            
            if (cur != pre) {
                ans.add(Arrays.asList(h[0], cur));
                pre = cur;
            }
        }
        
        return ans;
    }
}