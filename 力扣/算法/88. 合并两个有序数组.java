//2020-03-16 17:39:33
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, cnt=m+n-1;
        while(i>=0&&j>=0){
            nums1[cnt--] = nums1[i]>nums2[j] ? nums1[i--]: nums2[j--];
        }
        while(i>=0) nums1[cnt--] = nums1[i--];
        while(j>=0) nums1[cnt--] = nums2[j--];
    }
}
//2020-03-16 17:45:40