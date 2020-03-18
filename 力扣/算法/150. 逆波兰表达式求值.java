// 2020-03-18 22:00:15
class Solution {
    private Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String t : tokens) {
            switch (t) {
                case "+":
                    int[] num = getNum();
                    stack.push(num[1] + num[0]);
                    break;
                case "-":
                    num = getNum();
                    stack.push(num[1] - num[0]);
                    break;
                case "*":
                    num = getNum();
                    stack.push(num[1] * num[0]);
                    break;
                case "/":
                    num = getNum();
                    stack.push(num[1] / num[0]);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    public int[] getNum() {
        return new int[]{stack.pop(), stack.pop()};
    }
}
//2020-03-18 22:14:58