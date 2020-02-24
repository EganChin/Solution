/**
 * @author Egan
 * @date 2020/2/24 10:19
 **/

// begin at 2020/2/24 10:19
class Solution {
    int cnt;
    boolean[][] vis;

    public int movingCount(int m, int n, int k) {
        if(k==0) return 1;
        vis = new boolean[m][n];
        dfs(m, n, 0, 0, k);
        return cnt;
    }

    void dfs(int m, int n, int i, int j, int k){
        if(i >= m || i<0 || j>=n || j<0) return;
        if(vis[i][j]) return;
        if(i%10+i/10+j%10+j/10 > k) return;

        vis[i][j] = true;
        cnt++;
        dfs(m, n, i-1, j, k);
        dfs(m, n, i+1, j, k);
        dfs(m, n, i, j-1, k);
        dfs(m, n, i, j+1, k);

    }
}
// finish at 2020/2/24 10:33