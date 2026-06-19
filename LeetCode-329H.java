class Solution {

    public static int trace(int[][] matrix, int currR, int currC, int rLen, int cLen, int[][] ans) {
        if (ans[currR][currC] != 0) {
            return ans[currR][currC];
        }
        int[][] allD = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int gMax = 1;
        for (int[] temp : allD) {
            int r = currR + temp[0];
            int c = currC + temp[1];

            if (r >= 0 && r < rLen && c >= 0 && c < cLen && matrix[currR][currC] < matrix[r][c]) {
                gMax = Math.max(gMax, 1 + trace(matrix, r, c, rLen, cLen, ans));
            }
        }
        ans[currR][currC] = gMax;
        return gMax;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] ans = new int[r][c];

        int max = 1;
        for (int i = 0; r > i; i++) {
            for (int j = 0; j < c; j++) {

                max = Math.max(max, trace(matrix, i, j, r, c, ans));
            }
        }
        return max;
    }
}