class Solution { // shorter
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Deque < Character > stack = new ArrayDeque < > ();
        for (Character c: s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if(c == '{') {
                stack.offerFirst('}');
            } else if(stack.isEmpty() || stack.pollFirst() != c){
                return false;
            }
        }

        return stack.isEmpty();
    }
}



class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Deque < Character > stack = new ArrayDeque < > ();
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.offerFirst(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character topC = stack.pollFirst();
                if (c == ')' && topC != '(') {
                    return false;
                }
                if (c == ']' && topC != '[') {
                    return false;
                }
                if (c == '}' && topC != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}