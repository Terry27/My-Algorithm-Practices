class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        char res = 0;
        for(char c: sArr){
            res ^= c;
        }
        for(char c: tArr){
            res ^= c;
        }
        
        return res;
    }
}