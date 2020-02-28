//begin at 2020-02-28 10:40:34
class Solution {
    private String s;
    private int len;
    private List<List<String>> result = new ArrayList<>();
    private Deque<String> path = new ArrayDeque<>();

    public List<List<String>> partition(String s) {
        this.s = s;
        this.len = s.length();
        backtracking(0);
        return result;
    }

    public void backtracking(int index){
        if(index == len){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<len; i++){
            if(isPalindrome(index, i)){
                path.addLast(s.substring(index, i+1));
                backtracking(i+1);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome( int left, int right) {
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}

//finish at 2020-02-28 10:57:15