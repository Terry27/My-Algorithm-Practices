//cleaner edition
public class Trie {
    private TrieNode root;
    

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i< word.length(); i++){
            int c = word.charAt(i)-'a';
            if(curr.children[c] == null){
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i< word.length(); i++){
            int c = word.charAt(i)-'a';
            if(curr.children[c] == null){
                 return false;
            }
            curr = curr.children[c];
        }
        return curr.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0 ; i< prefix.length(); i++){
            int c = prefix.charAt(i)-'a';
            if(curr.children[c] == null){
                 return false;
            }
            curr = curr.children[c];
        }
        
        return true;
    }
}





class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode currTrie = root;
        char[] chars = word.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            if(currTrie.children[chars[currIndex]-'a'] == null){
                currTrie.children[chars[currIndex]-'a'] = new TrieNode();
            }
            if(currIndex == chars.length-1){
                currTrie.children[chars[currIndex]-'a'].isWord = true;
            }
            currTrie = currTrie.children[chars[currIndex]-'a'];
            currIndex++;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode currTrie = root;
        char[] chars = word.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            TrieNode child = currTrie.children[chars[currIndex]-'a'];
            if(child == null){
                return false;
            }
            if(currIndex == chars.length-1){
                return child.isWord;
            }
            currTrie = child;
            currIndex++;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode currTrie = root;
        char[] chars = prefix.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            TrieNode child = currTrie.children[chars[currIndex]-'a'];
            if(child == null){
                return false;
            }
            if(currIndex == chars.length-1){
                //if this is a word already
                if(child.isWord){
                    return true;
                }
                //see if there is any word that has been initialized
                for(TrieNode node: child.children){
                    if(node != null){
                        return true;
                    }
                }
            }
            currTrie = child;
            currIndex++;
        }
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");


class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode currTrie = root;
        char[] chars = word.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            int c= chars[currIndex]-'a';
            if(currTrie.children[c] == null){
                currTrie.children[c] = new TrieNode();
            }
            if(currIndex == chars.length-1){
                currTrie.children[c].isWord = true;
            }
            currTrie = currTrie.children[c];
            currIndex++;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode currTrie = root;
        char[] chars = word.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            TrieNode child = currTrie.children[chars[currIndex]-'a'];
            if(child == null){
                return false;
            }
            if(currIndex == chars.length-1){
                return child.isWord;
            }
            currTrie = child;
            currIndex++;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode currTrie = root;
        char[] chars = prefix.toCharArray();
        int currIndex = 0;
        while(currIndex < chars.length){
            TrieNode child = currTrie.children[chars[currIndex]-'a'];
            if(child == null){
                return false;
            }
            if(currIndex == chars.length-1){
                //if this is a word already
                if(child.isWord){
                    return true;
                }
                //see if there is any word that has been initialized
                for(TrieNode node: child.children){
                    if(node != null){
                        return true;
                    }
                }
            }
            currTrie = child;
            currIndex++;
        }
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");