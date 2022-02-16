package leetCode.queueAndStack.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 622. 设计循环队列
 * @author xinchan
 * @version 1.0.1 2022-02-12
 */
public class MyCircularQueue {
    private int[] circularQueue;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        circularQueue = new int[k + 1];
        this.front = 0;
        this.rear = 0;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            circularQueue[rear] = value;
            if (rear == circularQueue.length - 1) {
                rear = 0;
            } else {
                rear++;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            if (front == circularQueue.length - 1) {
                front = 0;
            } else {
                front++;
            }
            return true;
        }
        return false;
    }

    public int Front() {
        if (!isEmpty()) {
            return circularQueue[front];
        }
        return -1;
    }

    public int Rear() {
        if (!isEmpty()) {
            return circularQueue[(rear + circularQueue.length - 1) % circularQueue.length];
        }
        return -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % circularQueue.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(3);
        myCircularQueue.deQueue();
        System.out.println("success");
    }
}
