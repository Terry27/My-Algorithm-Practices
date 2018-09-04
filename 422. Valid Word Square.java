public class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int size = words.size();
        for(int row = 0; row< size; row++){
            for(int col = 0; col < words.get(row).length(); col++){
                if(col >= size || words.get(col).length() <= row || words.get(row).charAt(col) != words.get(col).charAt(row)){
                    return false;
                }
            }
        }
        
        return true;
    }
}