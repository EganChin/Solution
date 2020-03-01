import java.util.LinkedList;
import java.util.Queue;

// begin at 2020/3/1 14:40
import java.util.LinkedList;
import java.util.Queue;

// begin at 2020/3/1 14:40
class MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/// finish at 2020/3/1 14:53
