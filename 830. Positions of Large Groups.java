class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() < 3){
            return res;
        }
        int i = 0, j = 1;
        while(j < S.length()){
            char curC = S.charAt(j);
            if(curC != S.charAt(j-1)){
                if(j - i >= 3){
                    res.add(new ArrayList(Arrays.asList(i,j-1)));
                }
                i = j;
            }
            j++;
        }
        if(j - i >=3){
            res.add(new ArrayList(Arrays.asList(i,j-1)));
        }
        
        return res;
    }
}



class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() < 3){
            return res;
        }
        int i = 0;
        for(int j = 0; j < S.length(); j++){
            if(j == S.length()-1 || S.charAt(j) != S.charAt(j+1)){
                if(j - i >= 2){
                    res.add(new ArrayList(Arrays.asList(i,j)));
                }
                i = j+1;
            }
        }
        return res;
    }
}
