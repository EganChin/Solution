import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//2020-08-04 14:17:50
public class Solution {
    private List<List<Integer>> edges = new ArrayList<>();
    private int[] visited;
    private boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }
        for (int[] item : prerequisites) {
            edges.get(item[1]).add(item[0]);
        }
        for(int i=0; i<numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u){
        visited[u] = 1;
        for(int v : edges.get(u)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid) return;
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
//2020-08-04 14:50:18