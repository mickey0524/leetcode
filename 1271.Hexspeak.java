// https://leetcode.com/problems/hexspeak/
// algorithms
// Medium (46.54%)
// Total Accepted: 1,921
// Total Submissions: 4,128
// beats 100.0% of java submissions


class Solution {

    private static final String ERROR = "ERROR";
    private static final int[] decArr = new int[] { 0, 1, 10, 11, 12, 13, 14, 15 };
    private static final char[] hexArr = new char[] { 'O', 'I', 'A', 'B', 'C', 'D', 'E', 'F' };
    private static Map<Integer, Character> map = new HashMap<>();

    static {
        for (int i = 0; i < bitArr.length; i++) {
            map.put(decArr[i], hexArr[i]);
        }
    }

    public String toHexspeak(String num) {
        long n = Long.valueOf(num);
        long base = 1;
        while (base * 16 <= n) {
            base *= 16;
        }

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            while (base > n) {
                sb.append("O");
                base /= 16;
            }

            int divRes = (int) (n / base);
            if (divRes > 2 && divRes < 10) {
                return ERROR;
            }
            sb.append(map.get(divRes));
            n %= base;
            base /= 16;
        }

        while (base != 0) {
            sb.append("O");
            base /= 16;
        }

        return sb.toString();
    }

}