// https://leetcode-cn.com/problems/t9-lcci/
// algorithms
// Medium (70.19%)
// Total Accepted: 1,933
// Total Submissions: 2,754


class Solution {

    private static Map<Character, Integer> chToNum = new HashMap<>(26);

    static {
        chToNum.put('a', 2);
        chToNum.put('b', 2);
        chToNum.put('c', 2);
        chToNum.put('d', 3);
        chToNum.put('e', 3);
        chToNum.put('f', 3);
        chToNum.put('g', 4);
        chToNum.put('h', 4);
        chToNum.put('i', 4);
        chToNum.put('j', 5);
        chToNum.put('k', 5);
        chToNum.put('l', 5);
        chToNum.put('m', 6);
        chToNum.put('n', 6);
        chToNum.put('o', 6);
        chToNum.put('p', 7);
        chToNum.put('q', 7);
        chToNum.put('r', 7);
        chToNum.put('s', 7);
        chToNum.put('t', 8);
        chToNum.put('u', 8);
        chToNum.put('v', 8);
        chToNum.put('w', 9);
        chToNum.put('x', 9);
        chToNum.put('y', 9);
        chToNum.put('z', 9);
    }

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        int numLen = num.length();

        for (String w : words) {
            int wLen = w.length();
            if (numLen != wLen) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : w.toCharArray()) {
                sb.append(chToNum.get(ch));
            }
            String tmp = sb.toString();
            if (tmp.equals(num)) {
                res.add(w);
            }
        }

        return res;
    }

}