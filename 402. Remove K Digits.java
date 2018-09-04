public class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return num;
        }
        if( k>=num.length()){
            return "0";
        }
        int digits = num.length() - k;
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        
        for(int i=0; i< num.length(); i++){
            char cur = num.charAt(i);
            while(deque.size()>0  && cur < deque.peekLast() && deque.size() + num.length()- i-1 >= digits){
                deque.pollLast();
            }
            if(deque.size() < digits){
                deque.offerLast(cur);
            }
        }
        //remember to check isEmpty before calling any peek or poll
        while(!deque.isEmpty() && deque.peekFirst() == '0'){
            deque.pollFirst();
        }
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.length() == 0? "0": sb.toString();
    }
    
}