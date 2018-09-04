class Solution {
    public int[][] imageSmoother(int[][] M) {
        int r = M.length, c = M[0].length;
        int[][] res = new int[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {

                int count = 0;
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (i < 0 || i >= r || j < 0 || j >= c) {
                            continue;
                        }
                        count++;
                        res[row][col] += M[i][j];
                    }
                }
                res[row][col] /= count;
            }
        }
        return res;
    }
}