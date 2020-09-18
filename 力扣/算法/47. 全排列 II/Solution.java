import java.awt.List;
import java.util.ArrayList;

/*
47. 全排列 II re.0 i M
T: 2020-09-18 13:57:47 - 2020-09-18 15:19:06

Q: 给定一个可包含重复数字的序列，返回所有不重复的全排列。

A:先对数组排序，然后dfs递归搜索。
*/
class Solution {

    private List<Integer> tmp = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private boolean []vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums);
        return ans;
    }

    private void dfs(int index, int[] nums){
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            //确保从左到右填入重复数的集合
            if(vis[i] || (i>0 && nums[i-1]==nums[i] && !vis[i-1])){
                continue;
            }
            //select current num
            tmp.add(nums[i]);
            vis[i] = true;
            dfs(index+1, nums);
            vis[i] = false;
            tmp.remove(tmp.size()-1);
        }

    }
}
// 2020-09-18 15:19:06