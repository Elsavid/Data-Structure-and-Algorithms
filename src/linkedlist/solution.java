package linkedlist;

import java.util.Scanner;

public class solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
/*        //find kth value to last
        solution2.solution2();*/

        ListNode head = new ListNode(1,null);
        ListNode temp = head;
        for(int i=0;i<5;i++){
            int n = sc.nextInt();
            temp.next = new ListNode(n,null);
            temp = temp.next;
        }
        solution2.partition(head,3);
    }
}