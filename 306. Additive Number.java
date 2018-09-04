class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){return false;}
        
        for(int i = 1; i < num.length()/2+1; i++){
            if(num.charAt(0) == '0' & i > 1){return false;}
            long num1 = Long.parseLong(num.substring(0,i));
            for(int j = i+1; j <= num.length()- Math.max(i,j-i); j++){
                if(num.charAt(i) == '0' && j > i+1){break;}
                long num2 = Long.parseLong(num.substring(i,j));
                System.out.println(num2+"");
                if(helper(num.toCharArray(), j, num2, num1+num2)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[] cArr, int start, long num2, long target){
        if(start == cArr.length){return true;}
        if(cArr[start] == '0' && target > 0){return false;}
        String t = String.valueOf(target);
        for(int i = 0; i < t.length(); i++){
            if(start >= cArr.length || cArr[start++] != t.charAt(i)){
                return false;
            }
        }
        return helper(cArr, start, target, num2+target);
    }
}

class Solution { //determine first number, second number, then decide additive or not
    //use long to prevent overflow
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){return false;}
        for(int i = 1; i < num.length()/2+1; i++){
            if(num.charAt(0) == '0' & i > 1){return false;}
            long num1 = Long.parseLong(num.substring(0,i));
            for(int j = i+1; j <= num.length()- Math.max(i,j-i); j++){
                if(num.charAt(i) == '0' && j > i+1){break;} //leading zeros!
                long num2 = Long.parseLong(num.substring(i,j));
                if(helper(num.substring(j), num2, num1+num2)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(String s, long num2, long target){
        if(s.charAt(0) == '0' && target > 0){return false;}
        String t = String.valueOf(target);
        if(!s.startsWith(t)){
            return false;
        }
        if(t.length() == s.length()){return true;}
        return helper(s.substring(t.length()), target, num2+target);
    }
}