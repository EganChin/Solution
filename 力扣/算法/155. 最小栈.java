// 2020-03-11 19:38:28
class MinStack {

    Stack<Integer> major = new Stack<>();
    Stack<Integer> minor = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        major.push(x);
        if(minor.isEmpty() || x < minor.peek()){
            minor.push(x);
        }else{
            minor.push(minor.peek());
        }
    }

    public void pop() {
        major.pop();
        minor.pop();
    }

    public int top() {
        return major.peek();
    }

    public int getMin() {
        return minor.peek();
    }
}
//2020-03-11 19:45:37
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */