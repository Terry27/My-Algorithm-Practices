class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int rows = 1; rows <= numRows; rows++){
            List<Integer> arr = new ArrayList<>(rows);
            for(int i = 0; i < rows; i++){
                if(i == 0 || i == rows-1){
                    arr.add(1);
                }else{
                    if(res.isEmpty()){break;}
                    List<Integer> prevRow = res.get(res.size()-1);
                    arr.add(prevRow.get(i-1)+prevRow.get(i));
                }
            }
            res.add(arr);
        }
        return res;
    }
}