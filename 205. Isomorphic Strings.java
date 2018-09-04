class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sPos = new int[256];
        int[] tPos = new int[256];
        for(int i = 0; i < s.length();i++){
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if(sPos[curS] != tPos[curT]){return false;}
            sPos[curS] = i+1;
            tPos[curT] = i+1;
        }
        return true;
    }
}