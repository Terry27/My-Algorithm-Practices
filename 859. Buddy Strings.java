class Solution { //think globally
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        if(A.equals(B)){
            Set<Character> set = new HashSet<>();
            for(char c: A.toCharArray()){
                set.add(c);
            }
            return set.size() < A.length();
        }else{
            ArrayList<Integer> err = new ArrayList<>();
            for(int i = 0; i < A.length(); i++){
                if(A.charAt(i) != B.charAt(i)){
                    err.add(i);
                }
            }
            return err.size() == 2 && A.charAt(err.get(0)) == B.charAt(err.get(1)) && A.charAt(err.get(1)) == B.charAt(err.get(0));
        }
    }
}