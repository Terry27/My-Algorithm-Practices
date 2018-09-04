class Solution {
    public boolean canCross(int[] stones) {
        HashSet<String> set = new HashSet<>();
        return dfsMemo(0, 0, stones, set);
        // no need to store true case as it will simply return
    }
    
    private boolean dfsMemo(int pos, int k, int[] stones, HashSet<String> set){
        String key = pos+"#"+k;
        if(set.contains(key)){return false;}
        int prevStone = stones[pos];
        for(int i = pos+1; i<stones.length; i++){
            int curStone = stones[i];
            int diff = curStone - prevStone; 
            if(diff > k + 1){
                set.add(key);
                return false;
            }
            if(diff < k - 1 ){
                continue;
            }
            if(dfsMemo(i, diff, stones, set)){
                return true;
            }
        }
        return pos == stones.length - 1;
    }
}

class Solution {
    public boolean canCross(int[] stones) {
        HashMap<String, Boolean> map = new HashMap<>();
        return dfsMemo(0, 0, stones, map);
    }
    
    private boolean dfsMemo(int pos, int k, int[] stones, HashMap<String, Boolean> map){
        String key = pos+"#"+k;
        if(map.containsKey(key)){return map.get(key);}
        int prevStone = stones[pos];
        for(int i = pos+1; i<stones.length; i++){
            int curStone = stones[i];
            int diff = curStone - prevStone; 
            if(diff > k + 1){
                map.put(key, false);
                return false;
            }
            if(diff < k - 1 ){
                continue;
            }
            if(dfsMemo(i, diff, stones, map)){
                map.put(key, true);
                return true;
            }
        }
        boolean res = pos == stones.length - 1;
        map.put(key, res);
        return res;
        
    }
}