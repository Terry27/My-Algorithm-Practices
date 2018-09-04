class Solution { //space: O(1), time: O(S+T)
    public boolean backspaceCompare(String S, String T) {
        
        int i = S.length()-1;
        int j = T.length()-1;
        while(i >= 0 || j >= 0){
            
            int sDel = 0, tDel = 0;
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    sDel++;
                    i--;
                }else if(sDel > 0){
                    sDel--;
                    i--;
                }else{
                    break;
                }
            }
            
            while(j >= 0){
                if(T.charAt(j) == '#'){
                    tDel++;
                    j--;
                }else if(tDel > 0){
                    tDel--;
                    j--;
                }else{
                    break;
                }
            }
            
            
            if(i >= 0 && j>=0 && S.charAt(i) != T.charAt(j)){
                return false;
            }
            
            if((i >=0) != (j >= 0)){
                return false;
            }
            i--;
            j--;
            
        }
        
        return true;
    }
}



class Solution {  //space: O(S+T), time: O(S+T) 
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    
    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c != '#'){
                sb.append(c);
            }else if(sb.length() > 0){
                sb.setLength(sb.length()-1);
            }
        }
        return sb.toString();
    }
}