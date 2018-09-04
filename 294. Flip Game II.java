public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() <=1){
            return false;
        }
        
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] cArr){
        for(int i = 0; i <= cArr.length - 2; i++){
            if(cArr[i] == '+' && cArr[i+1] == '+'){
                cArr[i] = '-';
                cArr[i+1] = '-';
                boolean win = !canWin(cArr);
                cArr[i] = '+';
                cArr[i+1] = '+';
                if(win){
                    return true;
                }
            }
            
        }
        
        return false;
    }
    
}