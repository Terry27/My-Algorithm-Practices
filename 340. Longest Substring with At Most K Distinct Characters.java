class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, res = 0;
        for(int fast = 0; fast < s.length(); fast++){
            char curC = s.charAt(fast);
            map.put(curC, map.getOrDefault(curC, 0) + 1);
            while(map.size() > k){
                curC = s.charAt(slow);
                int curFreq = map.get(curC);
                if (curFreq == 1){
                    map.remove(curC);
                }else{
                    map.put(curC, curFreq - 1);
                }
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
