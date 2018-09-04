class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int groupLength = 0;
        for(int i = S.length()-1; i >=0; i--){
            char curChar = S.charAt(i);
            if(curChar != '-'){
                // *groupLength > 0
                if(groupLength > 0  && groupLength % K == 0){
                    sb.append('-');
                }
                groupLength++;
                sb.append(Character.toUpperCase(curChar));
            }
        }
        return sb.reverse().toString();
    }
}