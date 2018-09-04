public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
        });
        for(int i = 0; i < col; i++){
            pQueue.offer(new int[]{0,i,heightMap[0][i]});
            pQueue.offer(new int[]{row-1,i,heightMap[row-1][i]});
            visited[0][i] = true;
            visited[row-1][i] = true;
        }
        for(int i = 0; i < row; i++){
            pQueue.offer(new int[]{i,0,heightMap[i][0]});
            pQueue.offer(new int[]{i,col-1,heightMap[i][col-1]});
            visited[i][0] = true;
            visited[i][col-1] = true;
        }
        
        int res = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!pQueue.isEmpty()){
            int[] cur = pQueue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for(int[] dir : dirs){
                int newRow = curRow+dir[0];
                int newCol = curCol+dir[1];
                if(newRow>=0 && newRow < row && newCol>=0 && newCol<col && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    int height = heightMap[newRow][newCol];
                    res += Math.max(0, cur[2] - height);
                    pQueue.offer(new int[]{newRow,newCol, Math.max(cur[2],height)});
                }
            }
        }
        
        return res;
        
    }
}