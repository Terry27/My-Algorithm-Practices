public class Solution {
    public int findNthDigit(int n) {
        long nines = 9;
        int digits = 1;
        int start = 1;
        int finalNum  = 1;
        while(n > nines*digits){
            n -= nines*digits;
            nines *= 10;
            finalNum *=10;
            digits++;
        }
        int digit = (n-1) % digits;
        finalNum += (n-1)/digits;
        String temp = Integer.toString(finalNum);
        return Character.getNumericValue(temp.charAt(digit));
    }
}

