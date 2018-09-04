class Solution {
    public int strStr(String src, String target) {
        if(target == null || target.equals("")){return 0;}
        int[] table = lookupTable(target);
        int n = src.length();
        char[] sArr = src.toCharArray();
        char[] tArr = target.toCharArray();
        int start = 0; //target. moves target
        int end = 0; //source, keeps source
        while(end < n){
            if(start == target.length()){
                break;
            }else if(sArr[end] == tArr[start]){
                end++;
                start++;
            }else if(start == 0){
                end++;
            }else{
                start = table[start];
            }
        }
        if(start == target.length()){
            return end - start;
        }
        return -1;
    }
    
    private int[] lookupTable(String s){
        char[] c = s.toCharArray();
        int n = s.length();
        int[] table = new int[n+1];
        int start = 0, end = 1;
        while(end < n){
            if(c[start] == c[end]){
                table[++end] = ++start;
            }else if(start == 0){
                end++;
            }else{
                start = table[start];
            }
        }
        return table;
    }
}