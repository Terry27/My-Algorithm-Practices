class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for(int c: nums){
            int oldA = a;
            a = a&(~b)&(~c) | (~a)&b&c;
            b = (~oldA)&b&(~c) | (~oldA)&(~b)&c;
        }
        return a|b;
    }
}