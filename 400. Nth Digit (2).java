class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        int start = 1;
        long count = 9; //may overflow
        while(n > len*count){
            n -= len*count;
            len++;
            count *= 10;
            start *= 10;
        }
        String s = String.valueOf(start + (n - 1)/len);
        return s.charAt((n - 1) % len) -'0';
    }
}
                                  