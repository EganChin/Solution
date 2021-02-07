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

/*
5. 最长回文子串 re.1 ui M
T: 2021-02-07 11:15:51 - 2021-02-07 11:33:41

Q: 给你一个字符串 s，找到 s 中最长的回文子串。

A: 动态规划，逻辑见代码
*/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        String ans = "";
        for(int l=0; l<len; l++){
            for(int i=0; i+l<len; i++){
                int j = i+l;
                if(l==0){
                    dp[i][j] = true;
                }else if(l==1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = dp[i+1][j-1]&&(s.charAt(i) == s.charAt(j));
                }
                if(dp[i][j] && l+1 > ans.length() && (s.charAt(i) == s.charAt(j))){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}