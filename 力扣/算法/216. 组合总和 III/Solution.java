import java.awt.List;
import java.util.ArrayList;

/*
216. 组合总和 III re.0 i M
T: 2020-09-11 10:24:48 - 2020-09-11 10:37:10

Q:找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。 

A:使用dfs即可
*/
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return ans;
    }

    private void dfs(int k, int n, int cur){
        /*
        if(cur > 9 || tmp.size() > k || n < 0)
        ...
        if(tmp.size() == k && n==0)
        ...
        WA
        */
        if(tmp.size() == k && n==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(cur > 9 || tmp.size() > k || n < 0){
            return;
        }
        //unselect current number
        dfs(k, n, cur+1);
        if(n-cur >= 0){
            //select current number
            tmp.add(cur);
            dfs(k, n-cur, cur+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
//2020-09-11 10:33:25 WA
//2020-09-11 10:37:10 AC 69.81% 20.97%