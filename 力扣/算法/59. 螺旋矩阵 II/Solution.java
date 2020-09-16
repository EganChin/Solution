/*
59. 螺旋矩阵 II re.0 ui M
T: 2020-09-16 15:51:32 - 2020-09-16 16:15:59

Q: 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

A:建立一个初识值为零的nxn二维数组，然后模拟回形遍历。
每一次大遍历，都要分别小遍历右下左上四个方向，每次小遍历完成后，对应的范围应该缩小
直到小遍历n*n次
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int [][]a = new int[n][n];
        int cur = 1;
        int left=0, right = n-1, top = 0, bottom = n-1;
        while(cur <= n*n){
            //left -> right
            for(int i=left; i<=right; i++) a[top][i] = cur++;
            top++;
            // top->bottom
            for(int i=top; i<=bottom; i++) a[i][right] = cur++;
            right--;
            //right->left;
            for(int i=right; i>=left; i--) a[bottom][i] = cur++;
            bottom--;
            //bottom->top
            for(int i=bottom; i>=top;i--) a[i][left] = cur++;
            left++;
        }
        return a;
    }
}