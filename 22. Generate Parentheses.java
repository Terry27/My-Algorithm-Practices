public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        dfs(res, new StringBuilder(),0, 0, n);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, int leftParen, int rightParen, int n){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(leftParen < n){
            dfs(res,sb.append('('),leftParen+1,rightParen, n);
        }
        sb.setLength(len);
        if(leftParen > rightParen){
            dfs(res, sb.append(')'), leftParen, rightParen+1,n);
        }
        
    }
    
}