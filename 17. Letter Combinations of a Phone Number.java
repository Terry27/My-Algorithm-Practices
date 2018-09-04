public class Solution { //dfs, better
    final String[] TABLE = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, res, sb);
        return res;
    }
    
    private void dfs(String digits, int curIndex, LinkedList<String> res, StringBuilder sb){
        if(curIndex == digits.length()){
            res.add(sb.toString());
            return;
        }
        int curNum = Character.getNumericValue(digits.charAt(curIndex));
        for(char c : TABLE[curNum].toCharArray()){
            int oldLength = sb.length();
            sb.append(c);
            dfs(digits, curIndex+1, res, sb);
            sb.setLength(oldLength);
        }
    }
}

public class Solution { //queue
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        res.add("");
        String[] table = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0; i< digits.length();i++){
            int curNum = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i){
                String temp = res.remove();
                for(char c: table[curNum].toCharArray()){
                    res.add(temp+c);
                }
            }
        }
        return res;
    }
}