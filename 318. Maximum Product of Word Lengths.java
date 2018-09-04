public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        if(words == null || words.length == 0){
            return max;
        }
        int wLen = words.length;
        int[] value = new int[wLen];
        //use 26 bits of int to store occurence
        for(int i = 0; i < wLen; i++){
            for(int j = 0; j < words[i].length(); j++){
                value[i] |= 1<< words[i].charAt(j)-'a';
            }
        }
        
        for(int i = 0; i<wLen; i++){
            for(int j = i+1; j <wLen; j++){
                int curProd  = words[i].length()*words[j].length();
                if( (value[i]&value[j]) == 0 && curProd > max){
                    max = curProd;
                }
            }
        }
        
        return max;
    }
}