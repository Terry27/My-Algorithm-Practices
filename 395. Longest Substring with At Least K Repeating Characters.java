class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 1; i <= 26; i++){ //sliding window with exactly i unique characters
            int start = 0, end = 0;
            int curMax = 0;
            int count = 0; //# of unique char that has appeared at least k
            while(end < s.length()){
                char cEnd = s.charAt(end);
                map.put(cEnd, map.getOrDefault(cEnd, 0)+1);
                if(map.get(cEnd) == k){count++;}
                while(map.size() > i){ //maximum size == i
                    char cStart = s.charAt(start);
                    int freq2 = map.get(cStart);
                    if(freq2 == k){count--;}
                    if(freq2 == 1){
                        map.remove(cStart);
                    }else{
                        map.put(cStart, freq2-1);
                    }
                    start++;
                }
                if(map.size() == i && count == i){
                    curMax = Math.max(curMax, end - start + 1);
                }
                end++;
            }
            
            map.clear();
            res = Math.max(res, curMax);
        }
        return res;
    }
}