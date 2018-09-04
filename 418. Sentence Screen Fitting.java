public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for(String word: sentence){
            sb.append(word+" ");
        }
        String wholeS = sb.toString();
        int len = sb.length();
        int start = 0;
        for(int i = 0; i < rows; i++){
            start += cols;
            if(wholeS.charAt(start%len) == ' '){
                start++;
            }else{
                while(start > 0 && wholeS.charAt((start-1)%len) != ' '){
                    start--;
                }
            }
        }
        
        return start/len;
    }
}

//optimized one

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for(String word: sentence){
            sb.append(word+" ");
        }
        String wholeS = sb.toString();
        int len = wholeS.length();
        int[] offset = new int[len];
        for(int i = 1; i < len; i++){
            offset[i] = wholeS.charAt(i) == ' '? 1: offset[i-1]-1;
        }
        int start = 0;
        for(int i = 0; i< rows; i++){
            start += cols;
            start += offset[start%len];
        }
        
        return start/len;
    }
}