public class Solution {
    public String decodeString(String s) {
        if(s==null|| s.length() == 0){
            return "";
        }
        
        Deque<Integer> count = new ArrayDeque<>();
        Deque<StringBuilder> sentence = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num = 0 ;
                while(Character.isDigit(s.charAt(i))){
                    num = num*10 + (int)(s.charAt(i)- '0');
                    i++;
                }
                count.offerLast(num);
            }
            else if(s.charAt(i) == '['){
                i++;
                sentence.offerLast(sb);
                sb = new StringBuilder();
            }
            else if(s.charAt(i) == ']'){
                i++;
                StringBuilder temp  = sb;
                sb = sentence.pollLast();
                for(int j = count.pollLast(); j>0 ; j--){
                    sb.append(temp);
                }
                
            }
            else{
                sb.append(s.charAt(i++));
            }
            
        }
        
        return sb.toString();
    }
}