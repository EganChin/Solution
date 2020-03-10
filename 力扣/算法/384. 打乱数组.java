//2020-03-10 19:33:00
class Solution {

    int []nums;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int []arr = Arrays.copyOf(nums, nums.length);
        for(int i=0; i<arr.length; i++){
            swap(arr, i, random.nextInt(i+1));
        }
        return arr;
    }

    private void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//2020-03-10 19:49:02