// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
// algorithms
// Easy (85.38%)
// Total Accepted: 10,491
// Total Submissions: 12,287


class Solution {
    
    public int minimumSum(int num) {
        List<Integer> list = new ArrayList<>();
        for (char ch : String.valueOf(num).toCharArray()) {
            list.add(ch - '0');
        }
        
        Collections.sort(list);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (list.get(i) != 0 || sb1.length() != 0) {
                sb1.append(list.get(i));
            }
            
            if (i + 1 < size && list.get(i + 1) != 0 || sb2.length() != 0) {
                sb2.append(list.get(i + 1));
            }
        }
        
        int num1 = sb1.length() == 0 ? 0 : Integer.parseInt(sb1.toString());
        int num2 = sb2.length() == 0 ? 0 : Integer.parseInt(sb2.toString());
        
        return num1 + num2;
    }
    
}