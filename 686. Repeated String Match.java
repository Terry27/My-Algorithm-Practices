class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int rep = 1;
        while(sb.length() < B.length()){
            sb.append(A);
            rep++;
        }
        if(sb.toString().contains(B)){
            return rep;
        }
        if(sb.append(A).toString().contains(B)){
            return ++rep;
        }
        return -1;
    }
}
