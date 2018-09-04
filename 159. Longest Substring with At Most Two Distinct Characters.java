public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null){
            return 0;
        }
        int length = s.length();
        if(length <=2){
            return length;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0, max = 0;
        for(int i=0; i< length; i++){
            char runner = s.charAt(i);
            if(map.containsKey(runner)){
                map.put(runner, map.get(runner)+1);
            }else{
                map.put(runner,1);
            }
            while(map.size()>2){
                char follower = s.charAt(j);
                int temp = map.get(follower);
                if(temp  == 1){
                    map.remove(follower);
                }else{
                    map.put(follower, temp-1);
                }
                j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max;
        
    }
}