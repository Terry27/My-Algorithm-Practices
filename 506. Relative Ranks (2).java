class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pairs = new int[nums.length][2]; //2!!
        for(int i = 0; i < nums.length; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        String[] res = new String[nums.length];
        Arrays.sort(pairs, (a,b)->(Integer.compare(b[0],a[0])));
        for(int i= 0; i < pairs.length; i++){
            if(i == 0){
                res[pairs[i][1]] = "Gold Medal";
            }else if(i == 1){
                res[pairs[i][1]] = "Silver Medal";
            }else if(i == 2){
                res[pairs[i][1]] = "Bronze Medal";
            }else{
                res[pairs[i][1]] = i+1+"";
            }
        }
        return res;
    }
}