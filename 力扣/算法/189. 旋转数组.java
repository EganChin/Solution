//2020-03-06 21:28:43
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int []nums, int l, int r){
        for(; l<r; l++, r--){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}

//2020-03-06 21:46:29