//2020-09-01 15:56:28
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean [][]dp = new boolean[length][length];
        String ans = "";
        for(int l=0; l<length; l++){
            for(int i=0; i+l<length; i++){
                int j=i+l;
                if(l==0){
                    dp[i][j] = true;
                }else if(l==1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (dp[i+1][j-1]) && (s.charAt(i) == s.charAt(j));
                }
                if(dp[i][j]&&l+1>ans.length()){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
//dp 2020-09-01 16:27:23 28.23%