//2020-03-11 19:59:01
class Solution {
    int []nums;

    void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int partition(int l, int r, int p){
        int pivot = nums[p], left = l;
        swap(p, r);
        //将所有小于枢轴的值移到左边；
        for(int i=l; i<=r; i++){
            if(nums[i]<pivot)
                swap(i, left++);
        }

        swap(left, r);

        return left;
    }

    int quickSelect(int l, int r, int k){
        if(l==r) return nums[l];

        int p = l + new Random().nextInt(r-l);

        p = partition(l, r, p);

        if(k == p){
            return nums[k];
        }else if(k<p){
            return quickSelect(l, p-1, k);
        }
        return quickSelect(p+1, r, k);
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        return quickSelect(0, nums.length-1, nums.length-k);
    }
}

//2020-03-11 20:10:09