//begin at 2020-02-28 11:24:41
class Solution {
    private boolean []dp; //表示当前位置结尾的字符串能否被完全拆分
    private List<String> path = new ArrayList<>();
    private String s;
    private List<String> wordDict;
    private List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        int len = s.length();
        dp = new boolean[len+1];
        dp[0] = true;

        for(int end = 1; end <= len; end++){
            for(int start = 0; start < end; start++){
                if(dp[start] && wordDict.contains(s.substring(start, end))){
                    dp[end] = true;
                    break;
                }
            }
        }
        if(dp[len]){
            dfs(len);

        }
        return result;
    }

    public void dfs(int end){
        if(end == 0){
            StringBuilder builder = new StringBuilder();
            for(int i=path.size()-1; i>=0; i--){
                builder.append(path.get(i)).append(" ");
            }
            result.add(builder.substring(0, builder.length()-1).toString());
            return;
        }
        for(int start = 0; start <end; start++){
            if(dp[start]){
                String sub = s.substring(start, end);
                if(wordDict.contains(sub)){
                    path.add(sub);
                    dfs(start);
                    path.remove(path.size()-1);
                }
            }
        }
    }

}

//finish at 2020-02-28 12:19:04
