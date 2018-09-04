class Solution { //shorter but slower
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length()-t.length()) > 1 || s.equals(t)){
            return false;
        }
        int sLen = s.length(), tLen = t.length();
        if(sLen <= tLen){
            return oneEditDis(s, t);
        }else{
            return oneEditDis(t, s);
        }        
    }
    
    public boolean oneEditDis(String shorter, String longer){
        boolean gap = false;
        int i = 0, j = 0;
        while(i < shorter.length() && j < longer.length()){
            if(shorter.charAt(i) != longer.charAt(j)){
                if(gap){
                    return false;
                }
                gap = true;
                if(shorter.length() == longer.length()){
                    i++;
                }
            }else{
                i++;
            }
            j++;
        }
        return true;
    }
}









class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length()-t.length()) > 1 || s.equals(t)){
            return false;
        }
        int sLen = s.length(), tLen = t.length();
        if(sLen == tLen){
            boolean replace = false;
            for(int i = 0; i < sLen; i++){
                if(s.charAt(i) != t.charAt(i)){
                    if(replace){
                        return false;
                    }
                    replace = true;
                }
            }
            return true;
        }else if(sLen + 1 == tLen){
            return oneEditDis(s, t);
        }else{
            return oneEditDis(t, s);
        }
    }
    
    public boolean oneEditDis(String shorter, String longer){
        boolean gap = false;
        int i = 0, j = 0;
        while(i < shorter.length() && j < longer.length()){
            if(shorter.charAt(i) != longer.charAt(j)){
                if(gap){
                    return false;
                }
                gap = true;
            }else{
                i++;
            }
            j++;
        }
        return true;
    }
}


