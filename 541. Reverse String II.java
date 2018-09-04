class Solution {
    public String reverseStr(String s, int k) {
        char[] cArr = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2*k){
            int j = Math.min(i + k -1, s.length()-1);
            swap(cArr, i, j);
        }
        return new String(cArr);
    }
    
    private void swap(char[] cArr, int st, int ed){
        while(st < ed){
            char tmp = cArr[st];
            cArr[st] = cArr[ed];
            cArr[ed] = tmp;
            st++; ed--;
        }
    }
}