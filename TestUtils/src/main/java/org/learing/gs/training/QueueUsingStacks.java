package org.learing.gs.training;

import java.util.Stack;

public class QueueUsingStacks<T> {


        private Stack stack1; // For enqueue operations
        private Stack stack2; // For dequeue operations

        public QueueUsingStacks() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void enqueue(Object element) {
            stack1.push(element);
        }

        public Object dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }

            // If stack2 is empty, transfer elements from stack1 to stack2
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }

        public static void main(String[] args) {
            QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 2

            queue.enqueue(4);

            System.out.println("Size: " + queue.size()); // Output: 2
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 3
            System.out.println("Dequeued: " + queue.dequeue()); // Output: 4
        }
    }


