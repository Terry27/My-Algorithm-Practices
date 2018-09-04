class Solution { //Without memoization, O(n!!) double factorial
//T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)
    public boolean canWin(String s) {
        if(s == null || s.length() <= 1){return false;}
        return helper(s.toCharArray());
    }
    
    private boolean helper(char[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == '+' && arr[i+1] == '+'){
                arr[i] = '-';
                arr[i+1] = '-';
                boolean canWin = !helper(arr);
                arr[i] = '+';
                arr[i+1] = '+';
                if(canWin){return true;}
            }
        }
        return false;
    }
}


class Solution { //With memoization, O(2^n)
approx O(2^(n/2)) time. Explanation: consider worst case with all ¡°+¡±. Every possible substate(string) is visited only once. The number of possible substates is roughly total combinations out of n/2, which equals to 2^(n/2).
    //Gotta be something exponential. If you start with "+" * 2n, then the search will at least come across the 2n strings built just from "++" and "--", i.e., where every odd-index characters is the same as the character before it.
    HashMap<String, Boolean> map;
    public boolean canWin(String s) {
        if(s == null || s.length() <= 1){return false;}
        map = new HashMap<>();
        return helper(s.toCharArray());
    }
    
    private boolean helper(char[] arr){
        String tmp = new String(arr);
        Boolean res = map.get(tmp);
        if(res != null){
            return res;
        }
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == '+' && arr[i+1] == '+'){
                tmp = new String(arr);
                arr[i] = '-';
                arr[i+1] = '-';
                boolean canWin = helper(arr);
                arr[i] = '+';
                arr[i+1] = '+';
                if(!canWin){ //other player can't win = this player can win
                    map.put(tmp, true); 
                    return true;
                } 
            }
        }
        map.put(new String(arr), false);
        return false;
    }
}