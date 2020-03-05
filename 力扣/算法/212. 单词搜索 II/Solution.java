import java.util.*;

// begin at 2020/3/5 16:02
class Solution {

    Set<String> result = new HashSet<>();
    int m,n;
    char[][] board;
    boolean visit[][];
    int redirect[][] = new int[][]{ {0, -1}, {0, 1}, {1,0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        this.board = board;
        for(String w : words){
            root.insert(w);
        }

        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                find(i, j, root);
            }
        }

        return new LinkedList<>(result);
    }

    public void find(int i, int j, Trie cur){
        if(i<0 || i>=m || j<0 || j>=n || visit[i][j])
            return;
        cur = cur.next[board[i][j] - 'a'];
        if(cur == null){
            return;
        }
        visit[i][j] = true;
        if(cur.isString){
            result.add(cur.val);
        }
        for(int x=0; x<4; x++){
            find(i+redirect[x][0], j+redirect[x][1], cur);
        }
        visit[i][j] = false;
    }

    class Trie {
        private boolean isString = false;
        private Trie[] next = new Trie[26];
        private String val;

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            for(char ch : word.toCharArray()){
                if(root.next[ch-'a'] == null)
                    root.next[ch-'a'] = new Trie();
                root = root.next[ch-'a'];
            }
            root.isString = true;
            root.val = word;
        }

    }

}

// finish at 2020/3/5 16:46