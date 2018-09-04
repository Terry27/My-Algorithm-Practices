2k per step
total: n*2k
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (k >= n){return -1;}
        int[] pos = new int[n+1];
        for(int i = 0; i < n; i++){
            if(check(flowers[i], k, n, pos)){
                return i+1;
            }
        }
        return -1;
    }
    private boolean check(int flower, int k, int n, int[] pos){
        pos[flower] = 1;
        if(flower - k - 1 > 0 && pos[flower-k-1] == 1){
            boolean valid = true;
            for(int j = 1; j <= k; j++){
                if(pos[flower-j] != 0){
                    valid = false;
                    break;
                }
            }
            if(valid){return true;}

        }
        if(flower + k + 1 < n+1 && pos[flower + k + 1] == 1){
            boolean valid = true;
            for(int j = 1; j <= k; j++){
                if(pos[flower+j] != 0){
                    valid = false;
                    break;
                }
            }
            if(valid){return true;}
        }
        return false;
    }
}

TreeSet O(nlogn)
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


public int kEmptySlots(int[] flowers, int k) {
    int[] days = new int[flowers.length];
    for (int i = 0; i < days.length; i++) {
        days[flowers[i] - 1] = i + 1;
    }
    int left = 0;
    int right = k + 1;
    int res = Integer.MAX_VALUE;
    for (int i = 1; right < days.length; i++) {
        // current days[i] is valid, continue scanning
        if (days[i] > days[left] && days[i] > days[right]) {
            continue;
        }
       // reach boundary of sliding window, since previous number are all valid, record result
        if (i == right) {
            res = Math.min(res, Math.max(days[left],days[right]));
        }
        // not valid, move the sliding window
        left = i;
        right = left + k + 1;
    }
    return res == Integer.MAX_VALUE ? -1 : res;
}
