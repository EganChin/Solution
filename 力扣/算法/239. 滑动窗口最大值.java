//2020-03-12 23:56:56
class Solution {
    Deque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        int max = 0;
        for (int i = 0; i < k; i++) {
            cleanSmallerThanCur(i, k);
            deq.addLast(i);
            if (nums[i] > nums[max]) max = i;
        }

        int[] arr = new int[n - k + 1];
        arr[0] = nums[max];
        for (int i = k; i < n; i++) {
            cleanSmallerThanCur(i, k);
            deq.addLast(i);
            arr[i - k + 1] = nums[deq.getFirst()];
        }
        return arr;
    }

    private void cleanSmallerThanCur(int cur, int k) {
        if (!deq.isEmpty() && deq.getFirst() == cur - k)
            deq.removeFirst();

        while (!deq.isEmpty() && nums[cur] > nums[deq.getLast()])
            deq.removeLast();
    }

}
//2020-03-13 00:19:30