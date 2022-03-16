// class MinStack {
//     LinkedList<Integer> s1 = new LinkedList<>();
//     LinkedList<Integer> s2 = new LinkedList<>();
//     int minVal = Integer.MAX_VALUE;
//     int size = 0;
//     public MinStack() {

//     }

//     public void push(int val) {
//         s1.addFirst(val);
//         if(val <= minVal){
//             minVal = val;
//             s2.addFirst(val);
//         }else{
//             s2.addLast(val);
//         }
//         size++;
//     }

//     public void pop() {
//         int val = s1.poll();
//         if(val == minVal){
//             s2.poll();
//             minVal = s2.peek();
//         }
//         size--;
//     }

//     public int top() {
//         return s1.peek();
//     }

//     public int getMin() {
//         return s2.getFirst();
//     }
// }
class Min_Stack {
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
First Approach:
use linkelist s1 to implement stack
use another linked list to store min value. add min value to the left and other value to the right

issue:high memoery usage
advantage:O(1)
 */

/*
Second Approach:
by discuss
each node store the current min value(from current to the most right)
 */