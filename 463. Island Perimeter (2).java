class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count += 4; //here, not inside dirs
                    for(int[] dir: dirs){
                        int newI = dir[0]+i;
                        int newJ = dir[1]+j;
                        if(newI >=0 && newI < grid.length && newJ >=0 && newJ < grid[0].length && grid[newI][newJ] == 1){
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}