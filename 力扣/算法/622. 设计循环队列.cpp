//
// Created by Administrator on 2019/12/26.
//
#include <iostream>
#include <algorithm>
using namespace std;

class MyCircularQueue {
public:
    int *queue;
    int size, front, rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    MyCircularQueue(int k) {
    	size = k + 1;
        queue = new int[size];
        front = rear = 0;
        fill(queue, queue+size, -1);
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    bool enQueue(int value) {
        if (isFull())
            return false;
        queue[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    bool deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }


    /** Get the last item from the queue. */
    int Rear() {
    	if(isEmpty())
    		return -1;
        return queue[(rear-1+size)%size];
    }

    /** Checks whether the circular queue is empty or not. */
    bool isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    bool isFull() {
        return (rear + 1) % size == front;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */

int main() {
    MyCircularQueue circularQueue(3); // ���ó���Ϊ 3

    cout << circularQueue.enQueue(7) << endl;

    cout << circularQueue.deQueue() << endl;

    cout << circularQueue.Front() << endl;
    
    cout << circularQueue.deQueue() << endl;
    
    cout << circularQueue.Front() << endl;
    
    cout << circularQueue.Rear() << endl;

    cout << circularQueue.enQueue(0) << endl;

    cout << circularQueue.isFull() << endl;
    
    cout << circularQueue.deQueue() << endl;

    cout << circularQueue.Rear() << endl;
    
    cout << circularQueue.enQueue(3) << endl;   
    
    return 0;
}

// finish at 2019/12/26 17:01