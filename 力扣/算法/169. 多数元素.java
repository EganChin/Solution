// 2020-03-06 21:20:28
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, num=-1;
        for(int i:nums){
            if(count==0){
                num = i;
            }
            count += (count==i ? 1:-1);
        }
        return num;
    }
}
// 2020-03-06 21:24:44