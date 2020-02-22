// begin at 2020-02-22 11:44:14 

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size() == 0) return false;
        for (int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if (DFS(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    bool DFS(vector<vector<char>>& board, string word, int i, int j, int w){
        if(i <0 || i>=board.size() || j<0 || j>=board[0].size() || w >= word.size() || word[w] != board[i][j])
            return false;
        if(w == word.size()-1 && word[w] == board[i][j])
            return true;
        char temp = board[i][j];
        board[i][j] = '0';
        bool access = DFS(board, word, i-1, j, w+1) || DFS(board, word, i+1, j, w+1)
                    || DFS(board, word, i, j-1, w+1) || DFS(board, word, i, j+1, w+1);
        board[i][j] = temp;
        return access;

    }
};

//finish at /2020-02-22 12:15:22 
