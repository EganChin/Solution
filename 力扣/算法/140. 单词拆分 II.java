

// 2020-03-18 16:38:26
class Solution {

    boolean []dp;
    List<String> path = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int end=0; end<=s.length(); end++){
            for(int start=0; start<end; start++){
                if(dp[start] && wordDict.contains(s.substring(start, end))){
                    // System.out.println(s.substring(start, end));
                    dp[end] = true;
                    break;
                }
            }
        }

        if(dp[s.length()]){
            dfs(s, wordDict, s.length());
        }
        return result;
    }

    private void dfs(String s, List<String> wordDict, int end){
        if(end == 0){
            StringBuilder builder = new StringBuilder();
            if(!path.isEmpty())
                builder.append(path.get(path.size()-1));
            for(int i=path.size()-2; i>=0; i--){
                builder.append(" ").append(path.get(i));
            }
            result.add(builder.toString());
            return;
        }
        for(int start=0; start<end; start++){
            if(dp[start]){
                String word = s.substring(start, end);
                // System.out.println(word);
                if(wordDict.contains(word)){
                    path.add(word);
                    dfs(s, wordDict, start);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
//2020-03-18 17:09:52