class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
            if(!helper(matrix, 0, i)){
                return false;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(!helper(matrix, i, 0)){
                return false;
            }
        }
        return true;
    }
    
    private boolean helper(int[][] mat, int row, int col){
        int num = mat[row][col];
        while(row + 1 < mat.length && col + 1 < mat[0].length){
            if(mat[row+1][col+1] != mat[row][col]){
                return false;
            }
            row++;
            col++;
        }
        return true;
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}