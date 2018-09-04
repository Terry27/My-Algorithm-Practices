public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0; //pointers for word & abbr
        while(i < word.length() && j< abbr.length()){
            boolean rightFormat = false;
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9'){ // OR
                return false;
            }
            int num = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j)) ){
                num = num*10 + Character.getNumericValue(abbr.charAt(j));
                j++;
            }
            i += num;
        }
        
        return i==word.length() && j==abbr.length();
    }
}


