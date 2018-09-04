public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0] == null){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i< points.length; i++){
            for(int j = 0; j< points.length; j++){
                if(i != j){
                    int dis = distance(points[i],points[j]);
                    map.put(dis,map.getOrDefault(dis,0)+1);
                }
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int val = entry.getValue();
                res += val*(val-1);
            }
            map.clear();    
        }
        return res;
        
    }
    
    
    private int distance(int[] p, int[] q){
        int dx = p[0] - q[0];
        int dy = p[1] - q[1];
        return dx*dx+dy*dy;
    }
}