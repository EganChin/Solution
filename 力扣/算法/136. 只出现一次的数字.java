//begin at 2020-02-26 23:06:13
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}

/*
10
10 00
01 01
同数异或相消，零数异或本身
*/

//finish at 2020-02-26 23:27:22