public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int buildings = 0; // count # of 1s
        int[][] reachedBuildings = new int[row][col]; // see if each 0 reaches all buildings
        int[][] distances = new int[row][col]; // the total distance for each 0
        int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(grid[i][j] == 1){
                    boolean [][] visited = new boolean[row][col];
                    buildings++;
                    //BFS
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offerLast(new int[]{i,j});
                    
                    int curLevel = 1;
                    while(!queue.isEmpty()){
                        int curLevelSize = queue.size();
                        for(int s = 0; s < curLevelSize; s++){ // traverse by level
                            int[] curPoint = queue.pollFirst();
                            
                            for(int d = 0; d < 4; d++){ // care scale, can't use i
                                int nextRow = curPoint[0]+dirs[d][0];
                                int nextCol = curPoint[1]+dirs[d][1];
                                if(nextRow >=0 && nextRow < row && nextCol >=0 && nextCol < col && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0){
                                    queue.offerLast(new int[]{nextRow, nextCol});
                                    distances[nextRow][nextCol] += curLevel;
                                    visited[nextRow][nextCol] = true;
                                    reachedBuildings[nextRow][nextCol]++;
                                }
                            }
                        }
                        curLevel++;
                    }
                    
                }
            }
        }
        
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && reachedBuildings[i][j] == buildings){
                    minDis = Math.min(minDis, distances[i][j]);
                }
            }
            
        }
        
        return minDis == Integer.MAX_VALUE? -1: minDis;
        
    }
    
}