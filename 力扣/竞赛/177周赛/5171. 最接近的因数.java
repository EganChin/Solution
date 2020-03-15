//2020-03-15 17:19:12
class Solution {
    public int[] closestDivisors(int num) {
        int []nums1 = calculateDivisors(num+1);
        int []nums2 = calculateDivisors(num+2);
        return Math.abs(nums1[0]-nums1[1]) < Math.abs(nums2[0]-nums2[1]) ? nums1 : nums2;
    }

    private int[] calculateDivisors(int num){
        int sqrt = (int)Math.sqrt(num), i;
        if(sqrt*sqrt == num) return new int[]{sqrt, sqrt};
        for(i=sqrt; i>0 && num%i!=0; i--);
        return new int[]{i, num/i};
    }
}
//2020-03-15 17:29:34