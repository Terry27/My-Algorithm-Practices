class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= rowIndex+1; i++){
            res.add(1); //add a tailed one
            //from end-1 to 1, add element before it to current
            for(int j = i - 2; j >= 1; j--){
            // i = 3, 1,1 => 1,1,1 => 1,2,1
            // i = 4, 1,2,1 => 1,2,1,1 => 1,2,3,1 => 1,3,3,1
            // i = 5, 1,3,3,1 => 1,3,3,1,1 => 1,3,3,4,1 => 1,3,6,4,1 => 1,4,6,4,1
                res.set(j, res.get(j) + res.get(j-1));                
            }
        }
        return res;
    }
}