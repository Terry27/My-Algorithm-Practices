public class Solution {
    public boolean canPermutePalindrome(String s) {
        int count=0;
        if(s == null || s.length() == 0){
            return false;
        }
        int[] intArray = new int[128];
        for(char c: s.toCharArray()){
            intArray[(int)c]++;
        }
        for(int i: intArray){
            if(i%2 ==1){
                count++;
            }
        }
        if(count>1){
            return false;
        }
        return true;
        
    }
}