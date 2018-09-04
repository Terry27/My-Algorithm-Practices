class Solution {
    char[][] map = {{''},{''},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){return res;}
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, res, sb);
        return res;
    }
    
    private void helper(String digits, int idx, List<String> res, StringBuilder sb){
        if(idx == digits.length()){
            res.append(sb.toString());
        }
        int curNum = digits.charAt(idx)-'0';
        for(char c: map[curNum]){
            int len = sb.length();
            sb.append(c);
            helper(digits, idx+1, res, sb);
            sb.setLength(len);
        }
    }
}