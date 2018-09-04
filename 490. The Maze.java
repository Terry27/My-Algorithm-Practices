class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){return false;}
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offerLast(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] curPos = queue.pollFirst();
            if(curPos[0] == destination[0] && curPos[1] == destination[1]){
                return true;
            }
            // don't put visited here, takes more time
            for(int[] dir: dirs){
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                if(!visited[x-dir[0]][y-dir[1]]){
                    queue.offerLast(new int[]{x-dir[0],y-dir[1]});
                    visited[x-dir[0]][y-dir[1]] = true; //mark it here
                }
            }
        }
        
        return false;
    }
}