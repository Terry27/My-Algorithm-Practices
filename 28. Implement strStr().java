class Solution { //KMP O(m+n)
    public int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        String source = haystack;
        String target = needle;
        int[] lps = buildLPS(target);
        int i = 0;
        int j = 0;
        while(i < source.length() && j < target.length()){
            if(j == -1 || source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }else{
                j = lps[j];
            }
        }
        if(j == target.length()){
            return i-j;
        }
        return -1;
    }
    
    private int[] buildLPS(String pattern){ //find longest prefix suffix
        int[] lps = new int[pattern.length()+1]; //ONE MORE
        int i = 0;
        int j  = -1;
        lps[0] = -1;
        while(i < pattern.length()){
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                lps[i] = j; 
            }else{
                j = lps[j];
            }
        }
        return lps;
    }
}