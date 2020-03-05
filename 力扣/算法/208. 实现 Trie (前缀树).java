//begin at 2020-03-05 15:30:58

class Trie {
    private boolean isString = false;
    private Trie[] next = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for(char ch : word.toCharArray()){
            if(root.next[ch-'a'] == null)
                root.next[ch-'a'] = new Trie();
            root = root.next[ch-'a'];
        }
        root.isString = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = searchPrefix(word);
        if(root == null) return false;
        return root.isString;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix){
        Trie root = this;
        for(char ch : prefix.toCharArray()){
            if(root.next[ch-'a'] == null) return null;
            root = root.next[ch-'a'];
        }
        return root;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

//finish at 2020-03-05 15:53:54