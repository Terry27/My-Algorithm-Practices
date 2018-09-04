class Solution { //O(n), O(1)
    public int rob(int[] nums) {
        int rub = 0;
        int noRub = 0;
        for(int num: nums){
            int tmp = noRub;
            noRub = Math.max(noRub, rub);
            rub = tmp + num;
        }
        return Math.max(rub, noRub);
    }
}