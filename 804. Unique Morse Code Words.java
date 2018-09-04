class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0){return 0;}
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String word: words){
            set.add(toMoss(word, map));
        }
        
        return set.size();
    }
    
    private String toMoss(String word, String[] map){
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            sb.append(map[c-'a']);
        }
        return sb.toString();
    }
}


class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0){return 0;}
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            for(char c: word.toCharArray()){
                sb.append(map[c-'a']);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }
        
        return set.size();
    }
}