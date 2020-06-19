// https://leetcode-cn.com/problems/color-fill-lcci/
// algorithms
// Easy (54.41%)
// Total Accepted: 3,285
// Total Submissions: 6,037


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        fillColor(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void fillColor(int[][] image, int i, int j, int oldColor, int newColor) {
        int row = image.length, col = image[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }

        if (image[i][j] != oldColor) {
            return;
        }

        image[i][j] = newColor;

        fillColor(image, i + 1, j, oldColor, newColor);
        fillColor(image, i - 1, j, oldColor, newColor);
        fillColor(image, i, j + 1, oldColor, newColor);
        fillColor(image, i, j - 1, oldColor, newColor);
    }
}
