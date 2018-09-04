class Solution {
    public enum Numbers{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
        private int val;
        private Numbers(int val){
            this.val = val;
        }
    }
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(Numbers n: Numbers.values()){
            while(num >= n.val){
                sb.append(n);
                num -= n.val;
            }
        }
        return sb.toString();
    }
}