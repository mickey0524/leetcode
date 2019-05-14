// https://leetcode.com/problems/text-justification/
//
// algorithms
// Hard (23.16%)
// Total Accepted:    95,628
// Total Submissions: 412,929


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> l = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();
        
        int wordSum = 0, numSum = 0;
        
        for (String w : words) {
            int wLen = w.length();
            if (wordSum + numSum + wLen <= maxWidth) {
                wordSum += wLen;
                numSum++;
                tmp.offer(w);
            } else {
                StringBuilder sb = new StringBuilder();
                if (numSum == 1) {
                    sb.append(tmp.peek());
                    for (int i = 0; i < maxWidth - wordSum; i++) {
                        sb.append(" ");
                    }
                } else {
                    int[] space = new int[numSum - 1];
                    int spaceSum = maxWidth - wordSum;
                    Arrays.fill(space, spaceSum / (numSum - 1));
                    for (int i = 0; i < spaceSum % (numSum - 1); i++) {
                        space[i]++;
                    }
                    for (int i = 0; i < numSum - 1; i++) {
                        sb.append(tmp.pollFirst());
                        for (int j = 0; j < space[i]; j++) {
                            sb.append(" ");
                        }
                    }
                    sb.append(tmp.peek());
                }
                l.add(sb.toString());
                wordSum = wLen;
                numSum = 1;
                tmp.clear();
                tmp.offer(w);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numSum - 1; i++) {
            sb.append(tmp.pollFirst());
            sb.append(" ");
        }
        sb.append(tmp.peek());
        for (int i = 0; i < maxWidth - wordSum - (numSum - 1); i++) {
            sb.append(" ");
        }
        l.add(sb.toString());        
        
        return l;
    }
}