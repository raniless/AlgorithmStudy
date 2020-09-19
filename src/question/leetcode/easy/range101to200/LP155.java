package question.leetcode.easy.range101to200;

import java.util.PriorityQueue;
import java.util.Stack;

public class LP155 {
    public static void main(String[] args) {

    }
}

class MinStack {
    private Stack<Node> stack;
    private int minValue = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        minValue = Math.min(minValue, x);
        stack.push(new Node(x, minValue));
    }

    public void pop() {
        stack.pop();
        if(stack.isEmpty()) {
            minValue = Integer.MAX_VALUE;
        }
        else {
            minValue = stack.peek().getMinValue();
        }
    }

    public int top() {
        return stack.peek().getValue();
    }

    public int getMin() {
        return stack.peek().getMinValue();
    }
}

class Node {
    private int value;
    private int minValue;

    public Node(int value, int minValue) {
        this.value = value;
        this.minValue =minValue;
    }

    public int getValue() {
        return value;
    }

    public int getMinValue() {
        return minValue;
    }
}