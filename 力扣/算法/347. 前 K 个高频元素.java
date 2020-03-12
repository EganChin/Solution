//2020-03-12 23:37:34
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums)
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);

        Queue<Integer> head = new PriorityQueue<>(Comparator.comparingInt(countMap::get));

        for (int n : countMap.keySet()) {
            head.add(n);
            if (head.size() > k)
                head.poll();
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!head.isEmpty())
            list.addLast( head.poll());
        Collections.reverse(list);
        return list;
    }
}
//2020-03-12 23:55:24
