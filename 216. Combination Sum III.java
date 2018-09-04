class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        helper(new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    
    private void helper(ArrayList<Integer> list, int remK, int remN, int start){
        if(remK == 0){ // or list.size() == k
            if(remN == 0){
                res.add(new ArrayList<Integer>(list)); //deep copy
            }
            return;
        }
        
        for(int i = start; i <= 9; i++){
            list.add(i);
            helper(list, remK - 1, remN - i, i + 1); //i+1 very important
            list.remove(list.size()-1);
        }
    }
}