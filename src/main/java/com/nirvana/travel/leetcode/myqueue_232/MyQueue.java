package com.nirvana.travel.leetcode.myqueue_232;

import java.util.Stack;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/4/23
 */
public class MyQueue {

  Stack<Integer> helpStack = null;
  Stack<Integer> storeStack = null;
  /** Initialize your data structure here. */
  public MyQueue() {
    helpStack = new Stack<>();
    storeStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    if (storeStack.isEmpty()) {
      storeStack.push(x);
      return;
    }

    while (!storeStack.isEmpty()) {
      helpStack.push(storeStack.pop());
    }

    storeStack.push(x);

    while (!helpStack.isEmpty()) {
      storeStack.push(helpStack.pop());
    }

  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return storeStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return storeStack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return storeStack.isEmpty();
  }

}
