//2020-03-15 17:50:56
class Solution {

    boolean [][]vis;
    int cnt = 0;
    public int movingCount(int m, int n, int k) {
        vis = new boolean[m][n];
        dfs(m, n, k, 0, 0);
        return cnt;
    }

    private void dfs(int m, int n, int k, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j]) return;
        if(i/10 + i%10 + j/10 + j%10 > k) return;
        vis[i][j] = true;
        cnt++;
        dfs(m, n, k, i-1, j);
        dfs(m, n, k, i+1, j);
        dfs(m, n, k, i, j+1);
        dfs(m, n, k, i, j-1);
    }
}
//2020-03-15 18:02:46