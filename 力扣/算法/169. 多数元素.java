//2020-03-16 17:33:26
class Solution {
    public int majorityElement(int[] nums) {
        int flag = 0, n = 0;
        for(int i:nums){
            if(flag==0){
                n = i;
            }
            flag += n==i?1:-1;
        }
        return n;
    }
}
//2020-03-16 17:37:44