public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(n < 0){
            if(n == Integer.MIN_VALUE){//IMPORTANT
                n++;
                n = -n;
                x = 1/x;
                return myPow(x*x, n/2) * x * x;
            }else{
                x = 1/x;
                n = -n;
            }
        }
        
        if(n % 2 == 1){
            return myPow(x*x, n/2) * x;
        }else{
            return myPow(x*x, n/2);
        }
    }
}