//2020-03-11 18:55:11
// 满足 arr[i] < arr[j] < arr[k] ，而ijk不必相邻
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int n:nums){
            if(n<min){
                min = n;
            }else if(n<mid && n!=min){
                mid = n;
            }else if(n>mid){
                return true;
            }
        }
        return false;
    }
}
// 2020-03-11 19:13:29