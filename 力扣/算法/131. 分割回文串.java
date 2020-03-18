//2020/3/18 16:06:37
class Solution {
    String string;
    Deque<String> path = new ArrayDeque<>();
    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        string = s;
        backtracking(0);
        return lists;
    }

    private void backtracking(int index){
        if(index == string.length()){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<string.length(); i++){
            if(isPalindrome(index, i)){
                path.addLast(string.substring(index, i+1));
                // System.out.println(string.substring(index, i+1));
                backtracking(i+1);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(int left, int right){
        while (left<right){
            if(string.charAt(left++) != string.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
//2020-03-18 16:16:50