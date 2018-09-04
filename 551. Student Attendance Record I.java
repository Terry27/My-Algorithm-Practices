class Solution {
    public boolean checkRecord(String s) {
        if(s == null || s.length() ==0){
            return false;
        }
        int absCount = 0;
        int lateConsec = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absCount++;
                if(absCount > 1){
                    return false;
                }
                lateConsec = 0;
            }else if(c == 'L'){
                lateConsec++;
                if(lateConsec > 2){
                    return false;
                }
            }else{
                lateConsec = 0;
            }
        }
        
        return true;
    }
}