class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0, lowerCount = 0;
        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c)){
                upperCount++;
            }else{
                lowerCount++;
            }
        }
        int len = word.length();
        if(upperCount == len || lowerCount == len || (upperCount == 1 && Character.isUpperCase(word.charAt(0)))){
            return true;
        }
        
        return false;
    }
}

public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
}