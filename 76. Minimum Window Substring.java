public class Solution { // runtime O(2n),
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || t.length()>s.length()){
            return "";
        }
        int[] map = new int[128];
        for(int i = 0; i< t.length(); i++){
            map[t.charAt(i)]++;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = 0, counter = t.length(), minStart = 0, minLength = Integer.MAX_VALUE;
        while(end < chars.length){
            if(map[chars[end++]]-- > 0){
                counter--;
            }
            while(counter == 0){
                if(end - start < minLength){
                    minLength = end - start;
                    minStart = start;
                }
                if(map[chars[start++]]++ == 0){
                    counter++;
                }
            }
        }
        return minLength == Integer.MAX_VALUE? "": s.substring(minStart, minStart+minLength);
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null){
            return null;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        //remember to have a minStart variable
        int left = 0, right = 0, counter = t.length(), dist = Integer.MAX_VALUE, start = 0;
        while(right < s.length()){
            char c1 = s.charAt(right);
            Integer i = map.get(c1);
            if(i != null){
                if(i > 0){
                    counter--;
                }
                i--;
                map.put(c1, i);
            }
            
            while(counter == 0){
                char c2 = s.charAt(left);
                if(right - left + 1 < dist){
                    dist = right - left + 1;
                    start = left;
                }
                Integer j = map.get(c2);
                if(j != null){
                    if(j == 0){
                        counter++;
                    }
                    j++;
                    map.put(c2, j);
                }
                left++;
            }
            right++;
        }
        return dist == Integer.MAX_VALUE ? "": s.substring(start, start + dist);
    }
}