class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length(); i++){ //O(n*c), c is # of divisors
            if(s.length() % i != 0){continue;}
            String sub = s.substring(0, i);
            for(int j = i; j < s.length(); j += i){
                if(!sub.equals(s.substring(j, j+i))){
                    return false;
                }
            }
        }
        return true;
    }
}