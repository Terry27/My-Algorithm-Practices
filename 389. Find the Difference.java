public class Solution {
    public char findTheDifference(String s, String t) {
        int[] table = new int[26];
        for(int i = 0; i< t.length(); i++){
            table[t.charAt(i)-'a']++;
        }
        for(int i = 0; i< s.length(); i++){
            table[s.charAt(i)- 'a']--;
        }
        for(int i = 0; i< table.length; i++){
            if(table[i] == 1){
                return (char)(i+'a');
            }
        }
        
        throw new IllegalArgumentException();
    }
}

//bit edition
public class Solution {
    public char findTheDifference(String s, String t) {
        int test = 0;
        for(int i = 0; i< s.length(); i++){
            test ^= s.charAt(i);
        }
        for(int i = 0; i< t.length(); i++){
            test ^= t.charAt(i);
        }
        
        return (char)test;
    }
}