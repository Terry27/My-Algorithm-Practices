class Solution {
    
    HashMap<String, List<Integer>> cache;
    public List<Integer> diffWaysToCompute(String input) {
        cache = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        return helper(input, 0, input.length()-1);
    }
    
    private List<Integer> helper(String s, int start, int end){
        List<Integer> res = cache.get(start+"#"+end);
        if(res != null){
            return res;
        }
        res = new ArrayList<>();
        for(int i = start; i <= end; i++){
            char curC = s.charAt(i);
            if(curC == '*' || curC == '+' || curC == '-'){
                List<Integer> left = helper(s, start, i-1);
                List<Integer> right = helper(s, i+1, end);
                for(int l: left){
                    for(int r: right){
                        if(curC == '+'){
                            res.add(l+r);
                        }else if(curC == '-'){
                            res.add(l-r);
                        }else{
                            res.add(l*r);
                        }
                    }    
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(s.substring(start, end+1)));
        }
        cache.put(start+"#"+end, res);
        return res;
    }
}