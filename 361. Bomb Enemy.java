public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }   
        int[][] status = new int[grid.length][grid[0].length];
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 'E'){
                    checkStatus(grid, status, r, c);
                }
            }
        }    
        int max = 0;
        for(int r = 0; r < status.length; r++){
            for(int c = 0; c < status[0].length; c++){
                if(status[r][c]> max){
                    max = status[r][c];
                }
            }
        }
        return max;
    }
    
    private void checkStatus(char[][] grid, int[][] status, int row, int col){
        int top = 0, down = 0, left = 0, right = 0;
        while(row - top >= 0 && grid[row - top][col] != 'W'){
            if(grid[row-top][col] == '0'){
                status[row- top][col]++;
            }
            top++;
        }
        while(row + down < grid.length && grid[row + down][col] != 'W'){
            if(grid[row + down][col] == '0'){
                status[row + down][col]++;
            }
            down++;
        }
        while(col - left >= 0  && grid[row][col - left] != 'W'){
            if(grid[row][col - left] == '0'){
                status[row][col - left]++;
            }
            left++;
        }
        while(col+ right < grid[0].length && grid[row][col+ right] != 'W'){
            if(grid[row][col+ right] == '0'){
                status[row][col + right]++;
            }
            right++;    
        }
        
    }
}