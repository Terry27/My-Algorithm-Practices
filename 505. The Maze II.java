class Solution { //BFS O(mn*max(m,n)) 
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){return -1;}
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[maze.length][maze[0].length];
        queue.offerLast(start);
        for(int[] arr: dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int[] curPos = queue.pollFirst();
            
            for(int[] dir: dirs){
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                int curDis = 0;
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    curDis++;
                }
                if(dist[x-dir[0]][y-dir[1]] > dist[curPos[0]][curPos[1]] + curDis){ //important
                    queue.offerLast(new int[]{x-dir[0],y-dir[1]});
                    dist[x-dir[0]][y-dir[1]] = dist[curPos[0]][curPos[1]] + curDis; //mark it here
                }
            }
        }
        
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1:  dist[destination[0]][destination[1]];
    }
}

class Solution { //Dijkstra using PQ, time: O(mnlog(mn))

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){return -1;}
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] dist = new int[maze.length][maze[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        
        pq.offer(new int[]{start[0],start[1],0});
        for(int[] arr: dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        
        while(!pq.isEmpty()){
            int[] curPos = pq.poll();
            if(curPos[0] == destination[0] && curPos[1] == destination[1]){
                return curPos[2];
            }
            //if(dist[curPos[0]][curPos[1]] < curPos[2]){continue;}
            
            for(int[] dir: dirs){
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                int curDis = 0;
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    curDis++;
                }
                if(dist[x-dir[0]][y-dir[1]] > dist[curPos[0]][curPos[1]] + curDis){ //important
                    dist[x-dir[0]][y-dir[1]] = dist[curPos[0]][curPos[1]] + curDis;
                    pq.offer(new int[]{x-dir[0],y-dir[1],dist[x-dir[0]][y-dir[1]]});
                }
            }
        }
        
        return -1;
    }
}



