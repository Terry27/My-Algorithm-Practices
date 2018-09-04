public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0 && denominator != 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        String sign = ((numerator<0 &&denominator>0) || (numerator>0&&denominator<0)) ? "-":"";
        long numeratorL = Math.abs((long)numerator), denominatorL = Math.abs((long)denominator);
        sb.append(sign);
        sb.append(numeratorL/denominatorL);
        long remainder = numeratorL % denominatorL;
        if(remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(!map.containsKey(remainder) && remainder !=0){
            map.put(remainder, sb.length());
            remainder *=10;
            sb.append(remainder/denominatorL);
            remainder = remainder%denominatorL;
        }
        if(remainder != 0){
            int index = map.get(remainder);
            sb.insert(index,"(");
            sb.append(")");
        }
        return sb.toString();
        
    }
}