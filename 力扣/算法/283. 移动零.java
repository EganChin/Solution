//2020-03-10 19:06:20
class Solution {
    public void moveZeroes(int[] nums) {
        for(int l=0, r=0; r<nums.length; r++){
            if(nums[r]!=0){
                nums[l] = nums[r];
                if(l++!=r){
                    nums[r]=0;
                }
            }
        }
    }
}
//2020-03-10 19:18:38