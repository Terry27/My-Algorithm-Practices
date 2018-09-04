class Solution {
    public int[] singleNumber(int[] nums) {
        int test = 0; //XOR all nums, bit == 1 means they are different
        for(int i: nums){
            test ^= i;
        }
        int testBit = test & -test; //find lowest bit, BIT knowledge
        int num1 = 0, num2 = 0;
        for(int num: nums){
            if((num & testBit) > 0){
                num1 ^= num;
            }else{
                num2^= num;
            }
        }
        return new int[]{num1,num2};
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int test = 0; //XOR all nums, bit == 1 means they are different
        for(int i: nums){
            test ^= i;
        }
        int testBit = 1;
        for(int i = 0; i < 32; i++){ //find a bit that is diff in two nums
            if((test & (1 << i)) > 0){
                testBit = 1 << i;
                break;
            }
        }
        int num1 = 0, num2 = 0;
        for(int num: nums){
            if((num & testBit) > 0){
                num1 ^= num;
            }else{
                num2^= num;
            }
        }
        return new int[]{num1,num2};
    }
}
public int[] singleNumber(int[] nums) {
    int result[] = new int[2];        
    int xor = nums[0];
    for (int i=1; i<nums.length; i++)
    {
        xor ^= nums[i];
    }
    
    int bit = xor & ~(xor-1);
    int num1 = 0;
    int num2 = 0;
    
    for (int num : nums)
    {
        if ((num & bit) > 0)
        {
            num1 ^= num;
        }
        else
        {
            num2 ^= num;
        }
    }
    
    result[0] = num1;
    result[1] = num2;
    return result;
}