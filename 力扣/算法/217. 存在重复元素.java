//2020-03-10 18:59:49
class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
//2020-03-10 19:04:30