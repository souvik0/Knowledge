package com.stackQueue;
// Similar algorithm to find out max element.
import java.util.Stack;

public class StackWithMin {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    private Stack<Integer> normalstk = new Stack<Integer>();
    private Stack<Integer> minstk = new Stack<Integer>();
    // while pushing into 
    //Push into minstk if inserted element is smaller than smallest input element or if minstk is empty
    public void push(int input) {
      if (minstk.isEmpty() || (input < minstk.peek())) {
          minstk.push(input);
      }
      //push into normal stk in all condition
      normalstk.push(input);
    }

    //while popping if element is =minstk.top then pop from minstk too
    public int pop() {
      if (normalstk.isEmpty()) {
          return -1;
      }
      int popedElement = normalstk.pop();
      if (popedElement == minstk.peek()) {
          minstk.pop();//pop from minstk as well!  
      }
      return popedElement;
    }

    //Get the minimum at any point with O(1) time complexity
    public int getMin() {
      if (minstk.isEmpty()) {
          return -1;
      }
      return minstk.pop();
    }
}