/*
665. 非递减数列 re.0 ui E
T: 2021-02-07 09:38:34 - 2021-02-07 10:58:34

Q: 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

A:以三个用例为例：
例①： 4， 2, 5
当i=1时，nums[i]<nums[i-1]成立，此时应该修改nums[i-1]，因为i后未知
例②： 1, 4, 2, 5
当i=2时，nums[i]<nums[i-1]成立，此时应该修改nums[i-1]，理由同上
例③： 3, 4, 2, 5
当i=2时，nums[i]<nums[i-1]成立，此时应该修改nums[i]，因为nums[i-2]>nums[i]成立
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                count++;
                if(count > 1) return false;
                if(i==1 || nums[i-2] < nums[i]){
                    nums[i-1] = nums[i];
                }else if(i>=2 && nums[i-2] > nums[i]){
                    nums[i] = nums[i-1];
                }
            };
            
        }
        return true;
    }
}