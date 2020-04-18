// https://leetcode.com/problems/html-entity-parser/
// algorithms
// Medium (54.05%)
// Total Accepted: 8,606
// Total Submissions: 15,921


class Solution {

    private static final HashMap<String, Character> CHAR_ENTITY = new HashMap<>();
    private static final HashSet<Integer> ENTITY_LEN = new HashSet<>();
    private static final char BEGIN_CHAR = '&';

    static {
        CHAR_ENTITY.put("&quot;", '"');
        CHAR_ENTITY.put("&apos;", '\'');
        CHAR_ENTITY.put("&amp;", '&');
        CHAR_ENTITY.put("&gt;", '>');
        CHAR_ENTITY.put("&lt;", '<');
        CHAR_ENTITY.put("&frasl;", '/');

        for (String key : CHAR_ENTITY.keySet()) {
            ENTITY_LEN.add(key.length());
        }
    }

    public String entityParser(String text) {
        int curIdx = 0, preIdx = 0;
        StringBuilder sb = new StringBuilder();

        while ((curIdx = text.indexOf(BEGIN_CHAR, curIdx)) != -1) {
            String tmp;
            boolean isFound = false;

            for (int len : ENTITY_LEN) {
                tmp = text.substring(curIdx, curIdx + len);
                Character ch = CHAR_ENTITY.get(tmp);

                if (ch != null) {
                    sb.append(text.substring(preIdx, curIdx)).append(ch);
                    curIdx += len;
                    preIdx = curIdx;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                curIdx++;
            }
        }

        sb.append(text.substring(preIdx));

        return sb.toString();
    }
}