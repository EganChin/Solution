class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        Integer[] num = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            num[i] = nums[i];
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = Arrays.asList(num);

        for(int i=0; i<nums.length; i++){
            map1.put(nums[i], i);
        }
        list = list.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            if(!map2.containsKey(list.get(i)))
                map2.put(list.get(i), i);
        }

        int[] res = new int[num.length];
        for(int i=0; i<nums.length; i++){
            res[i] = map2.get(nums[i]);
        }

        return res;
    }
}

// finish at 2020/3/1 10:52