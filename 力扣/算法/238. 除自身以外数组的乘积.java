//2020-03-11 19:16:47
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1; i<ans.length; i++)
            ans[i] = ans[i-1]*nums[i-1];
        for(int i=ans.length-1, pro=1; i>=0; i--){
            ans[i] *= pro;
            pro *= nums[i];
        }

        return ans;
    }
}
//2020-03-11 19:34:12