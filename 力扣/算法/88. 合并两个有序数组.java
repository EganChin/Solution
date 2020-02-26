// begin at 2020-02-26 23:55:55
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k = m+n-1;
        while(i>=0 && j>=0){
            nums1[k--] = (nums1[i]<nums2[j]) ? nums2[j--] : nums1[i--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j+1);
    }
}

//finish at 2020-02-27 00:13:32