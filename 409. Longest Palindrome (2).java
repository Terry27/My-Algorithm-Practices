class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){return 0;}
        int[] freq = new int[256];
        for(char c: s.toCharArray()){
            freq[c]++;
        }
        int res= 0;
        boolean hasOdd = false;
        for(int i: freq){
            if(i % 2 == 0){
                res += i;
            }else{
                hasOdd = true;
                res += i-1;
            }
        }
        return hasOdd ? res + 1: res;
    }
}