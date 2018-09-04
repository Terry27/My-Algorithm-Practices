public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] res = new int[nums.length];
        
        int i=0, j=nums.length-1;
        
        int cur = a>=0? nums.length-1:0; 
        
        while(i<=j){
            int left = calc(nums[i],a,b,c);
            int right = calc(nums[j],a,b,c);
            if(a>=0){
                if(left >= right){
                    res[cur--] = left;
                    i++;
                }else{
                    res[cur--] = right;
                    j--;
                }
            }else{
                if(left >= right){
                    res[cur++] = right;
                    j--;
                }else{
                    res[cur++] = left;
                    i++;
                }
            }
        }
        
        return res;
    }
    
    private int calc(int x, int a, int b, int c){
        return a*x*x+b*x+c;
    }
}