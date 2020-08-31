import java.util.LinkedList;
import java.util.Queue;

//2020-08-31 15:30:41
class Solution {
    private boolean []open = new boolean[1010];
    private boolean []enter = new boolean[1010];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int count = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(queue.size() != 0){
            int idx = queue.remove();
            open[idx] = enter[idx] = true;
            List<Integer> keys = rooms.get(idx);
            for(Integer k : keys){
                if(!enter[k])
                    queue.offer(k);
                open[k] = true;
            }
        }
        for(int i=0; i<count; i++){
            if(!open[i]) return false;
        }
        return true;
    }
}
//2020-08-31 15:48:45 indepent 7%

class Solution {
    private boolean []enter = new boolean[1010];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int count = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        enter[0] = true;
        while(queue.size() != 0){
            int idx = queue.remove();
            count--;
            for(Integer key : rooms.get(idx)){
                if(!enter[key]){
                    queue.offer(key);
                    enter[key] = true;
                }
            }
        }
        return count == 0;
    }
}
//2020-08-31 16:05:07 unindepent 76.33%