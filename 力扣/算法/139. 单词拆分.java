// begin at 2020-02-28 11:00:02
class Solution {
    private Boolean []memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }

    public boolean wordBreak(String s, Set<String> wordDict, int start) {
        if(start == s.length()){
            return memo[start] = true;
        }

        if(memo[start] != null) return memo[start];

        for(int end=start+1; end<=s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)){

                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}

//finish at 2020-02-28 11:23:12