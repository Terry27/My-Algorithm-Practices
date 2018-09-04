class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1; //for num1
        int j = num2.length()-1; //for num2
        while(i >= 0 || j >= 0){ //must add until end
            int n1 = i >= 0 ? num1.charAt(i)-'0' : 0;
            int n2 = j >= 0 ? num2.charAt(j)-'0' : 0;
            int cur = n1+n2+carry;
            if(cur >= 10){
                carry = 1;
                sb.append(cur-10);
            }else{
                carry = 0;
                sb.append(cur);
            }
            i--;
            j--;
        }
        if(carry == 1){ //DONT FORGET CARRY!
            sb.append(1);
        }
        return sb.reverse().toString();
        
    }
}