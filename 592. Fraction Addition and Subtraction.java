import java.math.*;

class Solution {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0;
        int B = 1;
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            A = A*b + a*B;
            B *= b; 
            int curGCD = findGCD(A,B);
            A /= curGCD;
            B /= curGCD;
        }
        return A+"/"+B;
    
    }
    
    private int findGCD(int a, int b){
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
    
    // private int gcd(int a, int b) {
    //     return a != 0 ? gcd(b % a, a) : Math.abs(b);
    // }
    
    // The (?=) part is a zero-width positive lookahead. 
    // Since [-+] means - or +, the regex (?=[-+]) means the next element is either - or +.
    // Since | is logical or operator, "/|(?=[-+])" means the element is "/", or the next element is either - or +. 
    // For example, when expression = "-1/2+1/2-1/3",
    // Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])")
    // generates [-1, 2, +1, 2, -1, 3 ]. Note that the signs - and + are preserved.
}