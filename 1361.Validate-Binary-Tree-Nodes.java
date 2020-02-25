// https://leetcode.com/problems/validate-binary-tree-nodes/
// algorithms
// Medium (70.26%)
// Total Accepted: 5,314
// Total Submissions: 7,563
// beats 100.0% of java submissions


class Solution {

    private static boolean isIntersect;
    private static int meetNodeNum;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] isVisited = new boolean[n];

        isIntersect = false;
        meetNodeNum = 0;
        recursive(0, isVisited, leftChild, rightChild);

        if (isIntersect) {
            return false;
        }

        return meetNodeNum == n;
    }

    public void recursive(int idx, boolean[] isVisited, int[] leftChild, int[] rightChild) {
        if (isIntersect) {
            return;
        }
        if (isVisited[idx]) {
            isIntersect = true;
            return;
        }

        meetNodeNum++;
        isVisited[idx] = true;
        if (leftChild[idx] != -1) {
            recursive(leftChild[idx], isVisited, leftChild, rightChild);
        }

        if (rightChild[idx] != -1) {
            recursive(rightChild[idx], isVisited, leftChild, rightChild);
        }

    }
}