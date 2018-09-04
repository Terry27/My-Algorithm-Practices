public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length < 0){
            return new int[]{};
        }
        int[] res = new int[length];
        
        for(int[] update: updates){
            if(update[0]-1 >= 0){
                res[update[0]-1] -= update[2];
            }
            res[update[1]] += update[2];
        }
        
        for(int i = res.length-1; i>0; i--){
            res[i-1] += res[i];
        }
        
        return res;
    }
}