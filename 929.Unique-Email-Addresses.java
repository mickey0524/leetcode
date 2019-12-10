// https://leetcode.com/problems/unique-email-addresses/
//
// algorithms
// Easy (68.08%)
// Total Accepted: 161,790
// Total Submissions: 237,662


class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String m : emails) {
            int idx = m.indexOf("@");
            String local = m.substring(0, idx);
            String host = m.substring(idx + 1);

            idx = local.indexOf("+");
            if (idx != -1) {
                local = local.substring(0, idx);
            }

            String[] tmp = local.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String s : tmp) {
                sb.append(s);
            }
            sb.append("@").append(host);

            set.add(sb.toString());
        }

        return set.size();
    }
}