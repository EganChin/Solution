import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
7. 40. 组合总和 II re.0 i M
T: 2020-09-10 14:03:37 - 2020-09-10 14:22:16

Q:给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

A:先对candidate排序，然后使用dfs记录正确的组合，再使用set去重
*/
class Solution {

    private Set<List<Integer>> ans = new HashSet<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return new ArrayList<>(ans);
    }

    private void dfs(int[] candidates, int index, int target){
        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target < 0 || index>=candidates.length){
            return;
        }
        //unselect current number
        dfs(candidates, index+1, target);
        if(target-candidates[index]>=0){
            tmp.add(candidates[index]);
            dfs(candidates, index+1, target-candidates[index]);
            tmp.remove(tmp.size()-1);
        }
    }
}
//2020-09-10 14:22:16 8.81% 35.76%