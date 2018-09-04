public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        for(int i = 1; i<= str.length()/2; i++){ // i is divisor
            if(str.length() % i == 0){
                StringBuilder sb = new StringBuilder();
                String sample = str.substring(0,i);
                while(sb.length() < str.length()){
                    sb.append(sample);
                }
                if(sb.toString().equals(str)){
                    return true;
                }
            }
        }
        return false;
    }
}