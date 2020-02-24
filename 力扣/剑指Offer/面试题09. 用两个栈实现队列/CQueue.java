import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Egan
 * @date 2020/2/24 9:49
 **/
// begin at 2020/2/24 9:50
class CQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

    }

    public int deleteHead() {
        if(stack1.isEmpty() && stack2.isEmpty()) return -1;
        return stack1.pop();
    }

    public static void main(String[] args) {

        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

// finish at 2020/2/24 10:14