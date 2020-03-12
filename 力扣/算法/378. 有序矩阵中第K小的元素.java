//2020/3/12 23:18:42
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int left = matrix[0][0], right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = calGreaterThanMid(matrix, row, col, mid);
            if(count < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    private int calGreaterThanMid(int[][] matrix, int row, int col, int mid) {
        int i= row-1, j = 0, count=0;
        while (i>=0 && j<col){
            if(matrix[i][j] <= mid){
                count+=i+1;
                j++;
            }else {
                i--;
            }
        }
        return count;
    }
}
//2020-03-12 23:35:40