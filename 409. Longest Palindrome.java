public class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        boolean hasOdd = false;
        if(s == null || s.length() == 0){
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int maxOdd = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int curVal = entry.getValue();   
            if(curVal % 2 == 0){
                result += curVal;
            }else{
                result += curVal-1; //add biggest even number in this odd number
                hasOdd = true; // mark odd
            }
        }
        
        return result+ (hasOdd? 1:0);
    }
}