import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//2020-09-07 09:36:25
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> appearTime = new HashMap<>();
        for(int i: nums){
            appearTime.put(i, appearTime.getOrDefault(i, 0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return b[1] - a[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry : appearTime.entrySet()){
            int num = entry.getKey(), time = entry.getValue();
            if(queue.size() == k && queue.peek()[1] < time){
                queue.poll();
                queue.offer(new int[]{num, time});
            }
            else{
                queue.offer(new int[]{num, time});
            }
            
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
//2020-09-07 09:58:59