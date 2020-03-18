//2020-03-18 16:20:22
class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return wordBreak(s, wordDict, 0);
    }

    public boolean wordBreak(String s, List<String> wordDict, int start){
        if(start == s.length()){
            return memo[start] = true;
        }
        if(memo[start]!=null) return memo[start];
        for(int end = start; end<=s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)){
                return memo[end] = true;
            }
        }
        return memo[start] = false;
    }
}

//2020-03-18 16:30:46