//tree[i][j] saves the rangeSum of [i-(i&-i), i] x [j-(j&-j), j]
class NumMatrix { //O(logm*logn) update and query, O(mn*(logm*logn)) initialize

    int[][] tree;
    int[][] nums;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        m = matrix.length; 
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                update(i, j, matrix[i][j]); //don't forget BIT is based 1
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i = row + 1; i < tree.length; i += i & (-i)){ //i <=m
            for(int j = col + 1; j < tree[0].length; j += j & (-j)){
                tree[i][j] += diff;
            }
        }
    }
    
    public int query(int row, int col){
        int sum = 0;
        for(int i = row; i > 0; i -= i & (-i)){
            for(int j = col; j > 0; j -= j & (-j)){
                sum += tree[i][j];
            }
        }
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2+1,col2+1) - query(row1, col2+1) - query(row2+1, col1) + query(row1, col1);
        //rember +1 is inclusive and no +1 is exclusive
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */