class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] mask = new boolean[s.length()];
        for(String word: dict){
            int idx = 0;
            while(idx > -1){
                idx = s.indexOf(word, idx);
                if(idx > -1){
                    for(int i = idx; i < idx + word.length(); i++){
                        mask[i] = true;
                    }
                    idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(mask[i] && (i == 0 || !mask[i-1])){
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if(mask[i] && (i == s.length()-1 || !mask[i+1])){
                sb.append("</b>");
            }
        }
        return sb.toString();
        
    }
}