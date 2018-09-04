class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1; i >= 0; i--){
            char c = S.charAt(i);
            if(c == '-'){continue;}
            if(sb.length() % (K+1) == K){ //K=3, bc || -abc|| -abc
                sb.append('-');
            }
            sb.append(Character.toUpperCase(c));
            
        }
        return sb.reverse().toString();
    }
}