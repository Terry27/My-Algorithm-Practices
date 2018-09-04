class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){return "";}
        char[] chrs = s.toCharArray();
        int i = 0;
        int j = 0;
        while(j < chrs.length){
            if(chrs[j] == ' '){
                swapRange(chrs, i, j-1);
                i = j+1;
            }
            j++;
        }
        swapRange(chrs, i, j-1); //swap last part
        return new String(chrs);
    }
    
    private void swapRange(char[] chrs, int low, int high){
        while(low < high){
            char tmp = chrs[low];
            chrs[low] = chrs[high];
            chrs[high] = tmp;
            low++;
            high--;
        }
    }
}