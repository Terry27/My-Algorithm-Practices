class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        String res = "";
        char[] cArr = new char[26];
        int count = 0;
        for(char c: licensePlate.toCharArray()){
            int idx = Character.toLowerCase(c) - 'a';
            if(idx >= 0 && idx < 26){
                cArr[idx]++;
                count++;
            }
        }
        for(String word: words){
            char[] wArr = new char[26];
            for(char c: word.toCharArray()){
                wArr[c-'a']++;
            }
            if(match(cArr, wArr)){
                if(word.length() < minLen){
                    res = word;
                    minLen = word.length(); 
                }
            }
        }
        return res;
    }
    
    private boolean match(char[] c1, char[] c2){
        for(int i = 0; i < 26; i++){
            if(c2[i] < c1[i]){
                return false;
            }
        }
        return true;
    }
}