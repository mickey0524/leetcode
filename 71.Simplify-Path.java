// https://leetcode.com/problems/simplify-path/
//
// algorithms
// Medium (28.70%)
// Total Accepted:    149,468
// Total Submissions: 520,771

class Solution {
    public String simplifyPath(String path) {
        if (path.equals("")) {
            return "";
        }
        LinkedList<String> stack = new LinkedList<>();

        String[] arr = path.split("/+");
        for (String s : arr) {
            if (!s.equals("")) {
                switch (s) {
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                    break;
                default:
                    stack.offer(s);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String last = stack.isEmpty() ? "" : stack.pollLast();

        for (String s : stack) {
            sb.append(s).append("/");
        }

        sb.append(last);

        return sb.toString();
    }
}