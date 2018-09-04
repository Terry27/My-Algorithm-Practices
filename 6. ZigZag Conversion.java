class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1){
            return s;
        }
        int capacity = Math.min(numRows, s.length());
        StringBuilder[] sbList = new StringBuilder[capacity];
        for(int i = 0; i < capacity; i++){
            sbList[i] = new StringBuilder("");
        }
        int idx = 0;
        int dir = 0;
        for(int i = 0; i < s.length();i++){
            sbList[idx].append(s.charAt(i));
            if(idx == 0){
                dir = 1;
            }
            if(idx == numRows - 1){
                dir = -1;
            }
            idx += dir;
        }
        for(int i = 1; i < capacity; i++){
            sbList[0].append(sbList[i]);
        }
        return sbList[0].toString();
    }
}
