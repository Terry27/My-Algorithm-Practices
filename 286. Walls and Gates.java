public class Solution { //BFS, O(mn) time, O(mn)space
    public void wallsAndGates(int[][] rooms) {
        //use 0 as start point, spread from 0
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        Deque<int[]> queue = new LinkedList<>();
        for(int i = 0; i< rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offerLast(new int[]{i,j});
                }
            }
        }
        int[][] dir = new int[][]{{-1, 1, 0, 0},{0, 0,-1, 1}};
        
        while(!queue.isEmpty()){
            int[] p = queue.pollFirst();
            int row = p[0], col = p[1];
            for(int i= 0; i< 4; i++){
                int newR = row + dir[0][i];
                int newC = col + dir[1][i];
                if(newR < 0 || newR >= rooms.length || newC < 0 || newC >= rooms[0].length || rooms[newR][newC] != Integer.MAX_VALUE){
                    continue;
                }
                rooms[newR][newC] = rooms[row][col]+1;
                queue.offerLast(new int[]{newR, newC});
            }
        }
    }
    
    
    
    
}