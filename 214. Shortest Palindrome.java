class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        if(isPalindrome(s, 0, s.length()-1)){return s;}
        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i < s.length()*2 - 1; i++){
            
            if(isPartialPalindrome(s, i)){
                return sb.append(s.substring(2 * s.length() - i)).reverse().append(s).toString();
            }
        }
        return sb.append(s.substring(1)).reverse().append(s).toString();
    }
    
    public boolean isPartialPalindrome(String s, int len){
        int dif = len - s.length();
        int left = (len - 1) / 2;
        int right = len % 2 == 0 ? len / 2 : left;
        return isPalindrome(s, 0, right-dif+(left - dif));
    }
    
    public boolean isPalindrome(String s, int start, int end){
        int i = start, j = end;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}