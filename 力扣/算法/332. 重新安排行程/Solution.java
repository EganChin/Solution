import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//2020-08-27 13:49:33
class Solution {
    //节点->所有相邻节点
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    //欧拉通路
    private List<String> itinerary = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //建立图形
        for(List<String> ticket : tickets){
            String src = ticket.get(0), dst = ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String node){
        //入出度差为零的节点一定是最后遍历的节点，使用逆序遍历法，先遍历节点的所有邻居，再将其入栈
        while(map.containsKey(node) && map.get(node).size() > 0){
            String adjNode = map.get(node).poll();
            dfs(adjNode);
        }
        //逆序入栈，要将这个节点加到行程的头部
        itinerary.add(0,node);
    }
}
//2020-08-27 14:44:25