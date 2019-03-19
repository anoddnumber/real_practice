package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q, tmp;

    /** Initialize your data structure here. */
    public MyStack() {
        // q will keep everything in order
        q = new LinkedList<>();
        // tmp is used as a buffer to help push elements into the "stack"
        tmp = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!q.isEmpty()) {
            tmp.add(q.poll());
        }
        q.add(x);
        while (!tmp.isEmpty()) {
            q.add(tmp.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
