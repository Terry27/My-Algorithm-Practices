class Solution {
    public String crackSafe(int n, int k) {
        int totalSize = (int)Math.pow(k,n);
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append('0');
        }
        visited.add(sb.toString());
        if(dfs(sb, totalSize, n, k, visited)){
            return sb.toString();
        }
        return "";
    }
    
    private boolean dfs(StringBuilder sb, int totalSize, int n, int k, HashSet<String> visited){
        if(visited.size() == totalSize){return true;}
        String node = sb.substring(sb.length()-n+1);
        for(char c = '0'; c < '0'+ k; c++){ //instead of int
            String newStr = node+c;
            if(!visited.contains(newStr)){
                sb.append(c);
                visited.add(newStr);
                if(dfs(sb, totalSize, n, k, visited)){return true;}
                //if wrong path, remove this character
                visited.remove(newStr);
                sb.setLength(sb.length()-1);
            }
        }
        return false;
    }
}


class Solution {
    public String crackSafe(int n, int k) {
        int totalSize = (int)Math.pow(k,n);
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append('0');
        }
        visited.add(sb.toString());
        if(dfs(sb, totalSize, n, k, visited)){
            return sb.toString();
        }
        return "";
    }
    
    private boolean dfs(StringBuilder sb, int totalSize, int n, int k, HashSet<String> visited){
        if(visited.size() == totalSize){return true;}
        String node = sb.substring(sb.length()-n+1);
        for(int i = 0; i < k; i++){
            char c = (char)(i+'0');
            String newStr = node+c;
            if(!visited.contains(newStr)){
                sb.append(c);
                visited.add(newStr);
                if(dfs(sb, totalSize, n, k, visited)){return true;}
                //if wrong path, remove this character
                visited.remove(newStr);
                sb.setLength(sb.length()-1);
            }
        }
        return false;
    }
}












