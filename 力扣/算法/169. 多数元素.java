//begin at 2020-02-26 23:29:21
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int num:nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }
}

//finish at 2020-02-26 23:36:56