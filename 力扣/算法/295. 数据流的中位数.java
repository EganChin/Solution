//2020-03-12 22:58:46
class MedianFinder {

    private Queue<Integer> max = new PriorityQueue<>();
    private Queue<Integer> min = new PriorityQueue<Integer>(16, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size() < min.size()){
            max.add(min.poll());
        }
        // System.out.print(max.size() + "," + min.size());
        // if(max.size()!=0) System.out.print(","+max.peek());
        // if(min.size()!=0) System.out.print(","+min.peek());
        // System.out.println();
    }

    public double findMedian() {
        return max.size() > min.size() ? max.peek() : (max.peek() + min.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//2020-03-12 23:18:42