class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()){return false;}
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < strs.length; i++){
            char curP = pattern.charAt(i);
            if(!map.containsKey(curP)){
                if(!visited.add(strs[i])){ // care ! Exclamation mark
                    return false;
                }
                map.put(curP, strs[i]);
            }else if(!map.get(curP).equals(strs[i])){
                return false;
            }
        }
        return true;
    } 
}