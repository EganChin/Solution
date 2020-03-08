//2020-03-08 12:01:18
class Solution {
    int sum = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            if(manager[i]!=-1){
                List<Integer> list = tree.get(manager[i]);
                list.add(i);
            }
        }
        dfs(tree, headID, informTime[headID], informTime);
        return sum;

    }

    public void dfs(List<List<Integer>> tree, int head, int time, int[] informTime){
        List<Integer> list = tree.get(head);
        if(list.size()==0){
            return;
        }
        // System.out.println(head);
        sum = Math.max(sum, time);
        for(int i:list)
            dfs(tree, i, time+informTime[i], informTime);
    }
}
//2020-03-08 13:06:00