//2020-09-01 10:50:01
// class Solution {
//     public boolean PredictTheWinner(int[] nums) {
//         return dfs(nums, 0, nums.length-1, 1) >= 0;
//     }

//     private int dfs(int[] nums, int start, int end, int turn){
//         if(start == end){
//             return nums[start]*turn;
//         }
//         int startScore = nums[start]*turn - dfs(nums, start+1, end, -turn);
//         int endScore = nums[start]*turn - dfs(nums, start, end,-1 -turn);
//         return Math.max(startScore*turn, endScore*turn)*turn;
//     }
// }
//dfs 2020-09-01 11:43:54

// class Solution {
//     public boolean PredictTheWinner(int[] nums) {
//         int length = nums.length;
//         int [][]dp = new int[length][length];
//         for(int i=0; i<length; i++){
//             dp[i][i] = nums[i];
//         }
//         for(int i=length-2; i>=0; i--){
//             for(int j=i+1; j<length; j++){
//                 dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
//             }
//         }
//         return dp[0][length-1]>=0;
//     }

// }
//二维数组dp 2020-09-01 11:50:06

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int []dp = new int[length];
        for(int i=0; i<length; i++){
            dp[i] = nums[i];
        }
        for(int i=length-2; i>=0; i--){
            for(int j=i+1; j<length; j++){
                dp[j] = Math.max(nums[i]-dp[j], nums[j]-dp[j-1]);
            }
        }
        return dp[length-1]>=0;
    }

}
//一维数组dp 2020-09-01 13:40:30