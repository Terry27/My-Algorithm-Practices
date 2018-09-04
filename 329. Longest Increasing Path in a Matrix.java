class Solution { //O(mn)
    //no need for visited because we only go towards larger elements 
    //dir is stable, set as static final, only one copy will be initialized
    public static final int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int curMax = dfs(matrix, i, j, cache);
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
    
    private int dfs(int[][] mat, int i, int j, int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int curMax = 0;
        for(int[] d: dir){
            int row = i + d[0];
            int col = j + d[1];
            if(row >=0 && row < mat.length && col >=0 && col < mat[0].length && mat[row][col] > mat[i][j]){
                curMax = Math.max(dfs(mat, row, col, cache), curMax);
            }
        }
        cache[i][j] = curMax + 1;
        return curMax + 1;
    }
}