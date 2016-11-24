package easy;

import java.util.LinkedList;

/**Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is
 * empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty
 * stack).
 * Update (2015-06-11):
 * The class name of the Java function had been updated to MyStack instead of Stack.
 * <p>
 * Tags: Stack, Design
 * Similar Problems: (E) Implement Queue using Stacks
 * Created by Jeffrey on 2016/11/24.
 */
public class ImplementStackUsingQueues {
    LinkedList<Integer> list1 = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        list1.offer(x);
        for(int i = 0; i < list1.size() - 1; i++) {
            list1.offer(list1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        list1.poll();
    }

    // Get the top element.
    public int top() {
        return list1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list1.isEmpty();
    }
}
