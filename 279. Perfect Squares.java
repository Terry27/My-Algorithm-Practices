class Solution { //DP
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){ // square j starts from 1 !!!!
                min = Math.min(dp[i - j*j]+1, min);
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}


class Solution { //BFS
   
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>(); //VERY important
        for(int i = 1; i <= Math.sqrt(n); i++){
            int tmp = i*i;
            squares.add(tmp);
        }
        
        queue.offerLast(n);
        int step = 0;
        while(!queue.isEmpty()){
            step++;
            int total = queue.size();
            while(total-- > 0){
                int cur = queue.pollFirst();
                if(!visited.add(cur)){continue;} // cache the result
                for(int i = 0; i < squares.size(); i++){
                    int remaining = cur - squares.get(i);
                    if(remaining == 0){return step;}
                    if(remaining > 0){queue.offerLast(remaining);}
                }
            }
        }
        return -1;
    }
    
        //DFS is exhaustive, too slow
//     List<Integer> squares;
//     int min;
//     public int numSquares(int n) {
//         squares = new ArrayList<>();
//         min = Integer.MAX_VALUE;
//         for(int i = 1; i <= Math.sqrt(n); i++){
//             squares.add(i*i);  
//         }
//         helper(n, squares.size()-1, 0);
//         return min;
//     }
    
//     private void helper(int remaining, int idx, int count){
//         // System.out.println(remaining);
//         if(remaining < 0){
//             return;
//         }
//         if(remaining == 0){
//             min = Math.min(count, min);
//         }
//         for(int i = idx; i>=0; i--){
//             helper(remaining - squares.get(i), i, count + 1);
//         }
//     }
    
}