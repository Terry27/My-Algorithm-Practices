class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            // mask for each word using OR
            for(int j = 0; j < s.length(); j++){
                mask[i] |= (1 << (s.charAt(j) - 'a'));
            }
        }
        int max = 0; //set max = 0
        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                if((mask[i] & mask[j]) == 0){ //if two words have no intersection in masks
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
        
    }
}