public class Solution { //O(n^3)
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null && wordDict == null){
            return false;
        }
        if(s == null || wordDict == null){
            return true;
        }
        if(wordDict.contains(s)){
            return true;
        }
        boolean[] table = new boolean[s.length()+1];
        table[0] = true;
        for(int fast =  1; fast<= s.length(); fast++){
            for(int slow = 0; slow < fast; slow++){
                if(table[slow] && wordDict.contains(s.substring(slow, fast))){
                    table[fast] = true;
                    break;
                }
            }
        }
        
        return table[s.length()];
    }
}