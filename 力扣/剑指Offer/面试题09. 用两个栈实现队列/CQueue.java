import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Egan
 * @date 2020/2/24 9:49
 **/
// begin at 2020/2/24 9:50
class CQueue {

    private List<Integer> stack = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack.add(stack.size(), value);
    }

    public int deleteHead() {
        if(stack.size() == 0) return -1;
        int value = stack.get(0);
        stack.remove(0);
        return value;
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

// finish at 2020/2/24 9:59