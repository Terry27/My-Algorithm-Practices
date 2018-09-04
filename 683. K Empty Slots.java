class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if(k >= n){return -1;}
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i < n; i++){
            int f = flowers[i];
            
            Integer prev = ts.lower(f);
            if((prev != null && f - prev == k+1) ){
                return i+1;
            }
            Integer aft = ts.higher(f);
            if(aft != null && aft - f == (k+1)){
                return i+1;
            }
            ts.add(f);
        }
        return -1;
    }
}