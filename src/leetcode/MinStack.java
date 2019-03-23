package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    I initially thought I was supposed to implement a stack instead of a MinStack...
    So I just used an array and then used a min heap.
    There are some clever solutions on leetcode where they reuse a regular Stack
 */
class MinStack {

    PriorityQueue<Integer> pq;
    int[] stack;
    int size = 100;
    int pos = -1; // position of the top of the stack, -1 if empty

    /** initialize your data structure here. */
    public MinStack() {
        this.pq = new PriorityQueue<>();
        this.stack = new int[this.size];
    }

    public void push(int x) {
        if (this.pos + 1 >= this.size) {
            this.stack = Arrays.copyOf(this.stack, this.size * 2);
            this.size *= 2;
            push(x);
            return;
        }

        this.pos++;
        this.stack[this.pos] = x;
        this.pq.add(x);
    }

    public void pop() {
        if (this.pos >= 0) {
            if (this.stack[this.pos] == this.pq.peek()) {
                this.pq.poll();
            }
            this.pos--;
        }
    }

    public int top() {
        return this.stack[this.pos];
    }

    public int getMin() {
        return this.pq.peek();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(-1);
        System.out.println(m.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */