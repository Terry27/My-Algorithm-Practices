class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int maxRow = m - 1, maxCol = n - 1, minRow = 0, minCol = 0;
        while (minRow <= maxRow || minCol <= maxCol) {
            if (minRow <= maxRow) {
                for (int i = minCol; i <= maxCol; i++) {
                    res.add(matrix[minRow][i]);
                }
                minRow++;
            }
            if (minCol <= maxCol) {
                for (int i = minRow; i <= maxRow; i++) {
                    res.add(matrix[i][maxCol]);
                }
                maxCol--;
            }

            if (minRow <= maxRow) {
                for (int i = maxCol; i >= minCol; i--) {
                    res.add(matrix[maxRow][i]);
                }
                maxRow--;
            }
            if (minCol <= maxCol) {
                for (int i = maxRow; i >= minRow; i--) {
                    res.add(matrix[i][minCol]);
                }
                minCol++;
            }

        }
        return res;

    }
}
