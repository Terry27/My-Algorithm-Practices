public class Solution {
    
   
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0 || board[0].length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                    if(check(board, word, 0, i, j, visited)){
                        return true;
                    }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, String word, int index, int row, int col, boolean[][] visited){
        
        if(index  == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >=board[0].length || visited[row][col] || board[row][col] != word.charAt(index)){
            return false;
        }
        visited[row][col] = true;
        boolean checks = check(board, word, index+1, row+1,col,visited)||check(board, word, index+1, row,col+1,visited)||check(board, word, index+1, row-1,col,visited)||check(board, word, index+1, row,col-1,visited);
        visited[row][col] = false;
        return checks;
    }
}