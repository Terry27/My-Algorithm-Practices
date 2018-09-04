public class Solution {
    
    private int[][] jumps;
    private boolean[] visited;
    public int numberOfPatterns(int m, int n) {
        
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += dfs(1,1,m,n, 0)*4;
        count += dfs(2,1,m,n, 0)*4;
        count += dfs(5,1,m,n, 0);
        
        return count;
    }
    
    private int dfs(int num, int steps, int m, int n, int count){
        if(steps >= m){
            count++;
        }
        
        if(steps == n){
            return count;
        }
        visited[num] = true;
        for(int i = 1; i <=9; i++){
            int jump = jumps[num][i];
            if(!visited[i] && (jump == 0 || visited[jump])){
                count = dfs(i, steps+1, m, n, count);
            }
        }
        visited[num] = false;
        return count;
    }
}


