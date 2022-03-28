/* first stack s1 stores all elements
use second stack as a temporary stack to retrive the element from myQueue
this can be done by putting all elements from s1 and push into s2, so the order is reversed.
the top value on s2 is the value we want
after retriving the value we want, push back all elements from s2 into s1 */

// class MyQueue {
//     Stack<Integer> s1;
//     Stack<Integer> s2;
//     int size;

//     public MyQueue() {
//         s1 = new Stack<Integer>();
//         s2 = new Stack<Integer>();
//         size = 0;
//     }

//     public void push(int x) {
//         s1.push(x);
//         size++;
//     }

//     public int pop() {
//         int i;
//         int ans;
//         while(!s1.empty()){
//             i = s1.pop();
//             s2.push(i);
//         }
//         ans = s2.pop();
//         while(!s2.empty()){
//             i = s2.pop();
//             s1.push(i);
//         }
//         size--;
//         return ans;

//     }

//     public int peek() {
//         int i;
//         int ans;
//         while(!s1.empty()){
//             i = s1.pop();
//             s2.push(i);
//         }
//         ans = s2.peek();
//         while(!s2.empty()){
//             i = s2.pop();
//             s1.push(i);
//         }
//         return ans;
//     }

//     public boolean empty() {
//         return size==0;
//     }
// }

//1.amoritized O(1) for push and pop operations
//2.newest value on top of s1
//3.oldest value on top of s2
//4.s2 following the queue order.
//5.deque vlaue by poping  value from s2. the Best is O(1), if s2 is empty, pop form s1 and push into s2. so worst O(size)
class QueueViaStack {

    Stack<Integer> s1 = new Stack<Integer>(); //newest on top
    Stack<Integer> s2 = new Stack<Integer>(); //oldest on top
    int size = 0;

    public void push(int x) {
        s1.push(x);
        size++;
    }

    public int pop() {
        if(size!=0){
            size--;
        }
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop(); //don't forget this return statement;
    }

    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return size==0;
    }
}