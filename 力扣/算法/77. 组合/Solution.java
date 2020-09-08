import java.util.ArrayList;
import java.util.List;

//2020-09-08 14:03:14
class Solution {

    private List<List<Integer>> solutions = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return solutions;
    }

    private void dfs(int cur, int n, int k){
        //剪枝：如果当前组合的长度加上[cur, n]的长度小于 k，不可能构造出长度k的temp
        if(temp.size()+(n-cur+1)<k){
            return;
        }
        //长度符合，保存当前的temp
        if(temp.size() == k){
            solutions.add(new ArrayList<>(temp));
            return;
        }
        //选择当前的数字
        temp.add(cur);
        dfs(cur+1, n, k);
        //不选择当前的数字
        temp.remove(temp.size()-1);
        dfs(cur+1, n, k);
    }
}
//2020-09-08 14:40:21