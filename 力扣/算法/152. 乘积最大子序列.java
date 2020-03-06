// 2020-03-06 20:57:41
class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE, imax=1, imin=1;
        for(int i : nums){
            if(i<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*i, i);
            imin = Math.min(imin*i, i);

            max = Math.max(imax, max);
        }
        return max;
    }
}
//2020-03-06 21:11:27