class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] mask = new boolean[S.length()];
        for(String word: words){
            int idx = 0;
            while(idx != -1){
                idx = S.indexOf(word, idx);
                if(idx != -1){
                    for(int i = idx; i < idx + word.length(); i++){
                        mask[i] = true;
                    }
                    idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(mask[i] && (i == 0 || !mask[i-1])){
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if(mask[i] && (i == S.length()-1 || !mask[i+1])){
                sb.append("</b>");
            }
            
        }
        return sb.toString();
    }
}



class Solution { //complicated logic, can use mask == true as ²Î¿¼
    public String boldWords(String[] words, String S) {
        boolean[] mask = new boolean[S.length()];
        for(String word: words){
            int idx = 0;
            while(idx != -1){
                idx = S.indexOf(word, idx);
                if(idx != -1){
                    for(int i = idx; i < idx + word.length(); i++){
                        mask[i] = true;
                    }
                    idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if( (i== 0 && mask[i]) || (i > 0 && !mask[i-1] && mask[i])){
                sb.append("<b>");
            }
            if(i == S.length() -1 && mask[i]){
                sb.append(S.charAt(i));
                sb.append("</b>");
                break;
            }
               
            if(i > 0 && mask[i-1] && !mask[i]){
                sb.append("</b>");
            }
            sb.append(S.charAt(i));
            
        }
        return sb.toString();
    }
}