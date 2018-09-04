class Solution { //Dijkstra using PQ
    
    private class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        String s;
        public Point(int x, int y, int dist, String s){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.s = s;
        }
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = Integer.MAX_VALUE;
            this.s ="";
        }
        public int compareTo(Point p2){
            return this.dist == p2.dist ?  this.s.compareTo(p2.s): Integer.compare(this.dist, p2.dist);
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if(maze == null || maze.length == 0 || maze[0].length == 0 || hole == null || hole.length == 0){return "impossible";}
        
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}}; //left, right, up, down
        char[] dirsChar = {'l','r','u','d'};
        Point[][] mat = new Point[maze.length][maze[0].length];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length;j++){
                mat[i][j] = new Point(i,j);
            }
        }
        mat[ball[0]][ball[1]].dist = 0;
        pq.offer(mat[ball[0]][ball[1]]);
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if (p.x == hole[0] && p.y == hole[1]) {
                return p.s;
            }
            for(int i = 0; i < dirs.length; i++){
                int[] dir = dirs[i];
                int x = p.x + dir[0];
                int y = p.y + dir[1];
                int curDis = 0;
                // extra condition: stop when reach the destination
                while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && !(x== hole[0] && y == hole[1])){
                    x += dir[0];
                    y += dir[1];
                    curDis++;
                }
                //if not destination, then we moved one more step, substract it
                if(!(x== hole[0] && y == hole[1])){
                    x -= dir[0];
                    y -= dir[1];
                }
                
                Point newPoint = new Point(x, y, p.dist + curDis, p.s+dirsChar[i]);
                if(mat[x][y].compareTo(newPoint) > 0){
                    mat[x][y] = newPoint;
                    pq.offer(newPoint);
                }
            }
        }
        
        return mat[hole[0]][hole[1]].dist == Integer.MAX_VALUE ? "impossible": mat[hole[0]][hole[1]].s;
    }
}



