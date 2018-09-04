class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int r=0,b=0,g=0;
        for(int i = 0; i < costs.length; i++ ){
            int rPrev = r, bPrev = b, gPrev = g;
            r = costs[i][0] + Math.min(bPrev, gPrev);
            b = costs[i][1] + Math.min(rPrev, gPrev);
            g = costs[i][2] + Math.min(rPrev, bPrev);
        }
        return Math.min(r, Math.min(b,g));
    }
}



for(int j = 0; j < 3; j++) {
                costs[i][j] += Math.min(costs[i-1][(j+1)%3], costs[i-1][(j+2)%3]);
            }