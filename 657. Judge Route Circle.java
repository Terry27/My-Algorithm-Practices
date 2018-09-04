class Solution {
    public boolean judgeCircle(String moves) {
        int[] res = {0,0};
        for(char c: moves.toCharArray()){
            if(c == 'R'){
                res[0]++;
            }else if(c=='L'){
                res[0]--;
            }else if(c=='U'){
                res[1]--;
            }else{
                res[1]++;
            }
        }
        return res[0] == 0 && res[1] == 0;
    }
}