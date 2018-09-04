class Solution { //O(mn)
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){return;}
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offerLast(new int[]{i,j});
                }
            }
        }
        int step = 1;
        while(!queue.isEmpty()){ //BFS
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.pollFirst();
                for(int[] dir: dirs){
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE){
                        rooms[x][y] = step;
                        queue.offerLast(new int[]{x, y});
                    }
                }
            }
            step++;
        }
    }
}




class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){return;}
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offerLast(new int[]{i,j});
                }
            }
        }
        int step = 1;
        while(!queue.isEmpty()){ //BFS
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.pollFirst();
                for(int[] dir: dirs){
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n){
                        if(rooms[x][y] == Integer.MAX_VALUE){ //can be put into while loop
                            rooms[x][y] = step;
                            queue.offerLast(new int[]{x, y});
                        }
                    }
                }
            }
            step++;
        }
    }
}