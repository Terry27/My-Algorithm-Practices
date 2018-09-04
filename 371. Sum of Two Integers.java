class Solution {
    public int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int sum = a ^ b;
        // a & b: calculate carry, carry shift left to add to sum
        // a ^ b: calculate adding without carry
        //loop until carry is consumed
        while(carry != 0){
            int tmp = sum;
            sum = sum ^ carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }
}