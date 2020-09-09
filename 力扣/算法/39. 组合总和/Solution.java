import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//2020-09-09 09:45:00
class Solution {
    private List<List<Integer>> solutions = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(target, candidates, 0);
        return solutions;
    }

    private void dfs(int target, int[] candidates, int index){
        if(target<0 || index >= candidates.length){
            return;
        }
        if(target == 0){
            solutions.add(new ArrayList<>(temp));
            return;
        }
        //select current number
        temp.add(candidates[index]);
        dfs(target-candidates[index], candidates, index);
        //unselect current number
        temp.remove(temp.size()-1);
        dfs(target, candidates, index+1);
    }
}
//2020-09-09 09:55:57 i 55.43% 57.69%

class Solution {
    private List<List<Integer>> solutions = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(target, candidates, 0);
        return solutions;
    }

    private void dfs(int target, int[] candidates, int index){
        if(target<0 || index >= candidates.length){
            return;
        }
        if(target == 0){
            solutions.add(new ArrayList<>(temp));
            return;
        }

        //unselect current number
        dfs(target, candidates, index+1);
        if(target-candidates[index]>=0 ){
            //select current number
            temp.add(candidates[index]);
            dfs(target-candidates[index], candidates, index);
            temp.remove(temp.size()-1);
        }
    }
}
//剪枝优化
//2020-09-09 10:05:30 ui 87.50% 79.02%


/*
39. 组合总和 re.0 i M
T: 2020-09-09 09:45:00 - 09:55:57

Q:给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

A:参考77.组合，使用dfs通过选当前数和不选当前数两条路线实现搜索回溯。
*/