public class NumMatrix {

    int[][] rows;
    int m;
    int n;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        rows = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rows[i][j] = j == 0? matrix[i][j] : rows[i][j-1] + matrix[i][j]; 
            }
        }
        
    }

    public void update(int row, int col, int val) {
        int dif = val - matrix[row][col];
        for(int i = col; i < n; i++){
            rows[row][i] += dif;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            sum += col1 == 0? (rows[i][col2]):(rows[i][col2] - rows[i][col1-1]);
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);