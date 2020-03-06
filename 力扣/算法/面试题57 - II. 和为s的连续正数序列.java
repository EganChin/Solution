//2020-03-06 20:30:39
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new LinkedList<>();
        int l = 1, r = 1, sum = 0;
        while(l<=target/2){
            if(sum < target){
                sum += r++;
            }else if(sum > target){
                sum -= l++;
            }else{
                int []list = new int[r-l];
                for(int i=l; i<r; i++){
                    list[i-l] = i;
                }
                lists.add(list);
                sum -= l++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}

//2020-03-06 20:51:05