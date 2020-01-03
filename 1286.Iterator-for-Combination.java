// https://leetcode.com/problems/iterator-for-combination/
// algorithms
// Medium (63.4%)
// Total Accepted: 3,064
// Total Submissions: 4,758
// beats 100.0% of java submissions


class CombinationIterator {

    private char[] originCharArray;
    private char[] curCharArray;
    private int combinationLength;
    private int originStringLength;

    public CombinationIterator(String characters, int combinationLength) {
        this.originCharArray = characters.toCharArray();
        this.curCharArray = Arrays.copyOf(originCharArray, combinationLength);
        this.combinationLength = combinationLength;
        this.originStringLength = characters.length();
    }

    public String next() {
        String res = new String(curCharArray);
        int targetIdx = -1;

        for (int i = 0; i < combinationLength; i++) {
            int cIdx = combinationLength - i - 1;
            int oIdx = originStringLength - i - 1;
            if (curCharArray[cIdx] != originCharArray[oIdx]) {
                targetIdx = cIdx;
                break;
            }
        }

        if (targetIdx == -1) {
            curCharArray = null;
        } else {
            int beginIdx = -1;
            for (int i = 0; i < originStringLength; i++) {
                if (originCharArray[i] == curCharArray[targetIdx]) {
                    beginIdx = i + 1;
                }
            }
            System.arraycopy(originCharArray, beginIdx, curCharArray, targetIdx, combinationLength - targetIdx);
        }

        return res;
    }

    public boolean hasNext() {
        if (curCharArray == null) {
            return false;
        }

        return true;
    }

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters,
 * combinationLength); String param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */