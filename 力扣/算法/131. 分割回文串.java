import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//2020-08-27 10:05:13
class Solution {
    private String s;
    private Deque<String> path = new ArrayDeque<>();
    private List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        this.s = s;
        backtracking(0);
        return lists;
    }

    private void backtracking(int index){
        if(index == s.length()){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int right=index; right<s.length(); right++){
            if(isPandrome(index, right)){
                path.addLast(s.substring(index, right+1));
                backtracking(right+1);
                path.removeLast();
            }
        }
    }

    private boolean isPandrome(int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
//2020-08-27 10:34:26