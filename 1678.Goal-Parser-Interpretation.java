// https://leetcode.com/problems/goal-parser-interpretation/
// algorithms
// Easy (91.37%)
// Total Accepted: 5,271
// Total Submissions: 5,769
// beats 100.0% of java submissions


class Solution {
    
    private static final Map<String, String> mapping = new HashMap<>();
    
    private static final String G = "G";
    
    private static final String BRACKETS = "()";
    
    private static final String BRACKETS_AL = "(al)";
    
    static {
        mapping.put(G, "G");
        mapping.put(BRACKETS, "o");
        mapping.put(BRACKETS_AL, "al");
    }
    
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        int idx = 0;
        
        while (idx < len) {
            if (G.equals(command.substring(idx, idx + 1))) {
                sb.append(mapping.get(G));
                idx++;
            } else if (BRACKETS.equals(command.substring(idx, idx + BRACKETS.length()))) {
                sb.append(mapping.get(BRACKETS));
                idx += BRACKETS.length();
            } else {
                sb.append(mapping.get(BRACKETS_AL));
                idx += BRACKETS_AL.length();   
            }
        }     
        
        return sb.toString();
    }
}