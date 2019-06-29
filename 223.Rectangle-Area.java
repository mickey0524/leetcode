// https://leetcode.com/problems/rectangle-area/
//
// algorithms
// Medium (35.98%)
// Total Accepted:    88,608
// Total Submissions: 246,270
// beats 100.0% of java submissions

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area1 = (D - B) * (C - A);
        long area2 = (H - F) * (G - E);
        
        if (H <= B || F >= D || C <= E || G <= A) {
            return (int)(area1 + area2);
        }
        
        long l = Math.max(A, E);
        long r = Math.min(C, G);
        long t = Math.min(D, H);
        long b = Math.max(B, F);
        
        long intersect = (t - b) * (r - l);
        
        return (int)(area1 + area2 - intersect);
    }
}