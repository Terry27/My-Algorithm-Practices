public class Solution { //setLength important
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if(word == null){
            return res;
        }
        
        dfs(word.toCharArray(), res, 0, 0, new StringBuilder());
        return res;
    }
    
    private void dfs(char[] word, List<String> res, int curIndex, int num, StringBuilder sb){
        int len = sb.length();
        if(curIndex == word.length){
            if(num !=0){
                sb.append(num);
            }
            res.add(sb.toString());
            return;
        }
        
        dfs(word, res, curIndex+1, num+1, sb);
        sb.setLength(len);
        if(num != 0){
            sb.append(num);
        }
        dfs(word, res, curIndex+1, 0, sb.append(word[curIndex]));
        
    }
}