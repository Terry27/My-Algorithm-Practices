class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            root.insert(word);
        }
        String[] max = {""};
        dfs(root, 0, max);
        return max[0];
    }
    
    private void dfs(TrieNode root, int count, String[] max){
        for(int i = 0; i < root.children.length; i++){
            if(root.children[i] == null){continue;}
            if(root.children[i].isWord){
                TrieNode child = root.children[i];
                count++;
                if(count > max[0].length()){
                    max[0] = child.s;
                }else if(count == max[0].length()){
                    String newS = child.s;
                    max[0] = max[0].compareTo(newS) < 0 ? max[0]: newS; 
                    //if left <right, compareTo returns negative  
                }
                dfs(child, count, max);
                count--;
            }
        }
    }
    
    private class TrieNode{
        String s; //use s here, meaning the string that ends here
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            isWord = false;
            this.s = null;
            this.children = new TrieNode[26];
        }
        public void insert(String s){
            TrieNode root = this;
            for(char c: s.toCharArray()){
                if(root.children[c-'a'] == null){
                    root.children[c-'a'] = new TrieNode();
                }
                root = root.children[c-'a'];
            }
            root.isWord = true;
            root.s = s;
        }
    }
}