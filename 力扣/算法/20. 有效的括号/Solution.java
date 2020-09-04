//2020-09-04 14:24:49
class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Set<Character> left = new HashSet<>(){{add('{');add('[');add('(');}};
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length; i++){
            if(left.contains(str[i])){
                stack.push(str[i]);
            }else{
                if(stack.isEmpty() || !isMatch( stack.pop(), str[i])){ 
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char a, char b){

        if(a=='{') return b=='}';
        if(a=='[') return b==']';
        if(a=='(') return b==')';
        return false;
    }
}
//2020-09-04 14:43:37