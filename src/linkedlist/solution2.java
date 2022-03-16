package linkedlist;

import java.util.List;
import java.util.*;

public class solution2 {

    public static void solution2(){
        ListNode head = new ListNode(12,null);
        ListNode temp = head;
        for(int i=0;i<5;i++){
            temp.next = new ListNode(i,null);
            temp = temp.next;
        }

        //findKthtolast(head,2);
        int[] s2 = {0};
        System.out.println(findKthtolast2(head,10,s2).val);
    }

    public static int findKthtolast(ListNode head, int k){
        if(head == null){
            return 0;
        }
        int count;
        count = findKthtolast(head.next,k)+1;
        if(count == k){
            System.out.println(head.val);
        }
        return count;
    }

    //store the count in static variable in this case is array.
    //notice we could not use int instead
    public static ListNode findKthtolast2(ListNode head, int k,int[] val){
        if(head == null){
            return null;
        }
        int count;
        ListNode node = findKthtolast2(head.next,k,val);
        val[0] ++;
        if(val[0] == k){
            return head;
        }
        return node;
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode newhead = head;
        ListNode newlast = head;
        ListNode t = head;
        ListNode temp;
        while(t!=null){
            temp = t.next;
            if(t.val < x){
                t.next = newhead;
                newhead =t;
                System.out.println(t.val);
            }else{
                newlast.next = t;
                newlast = t;
            }
            t = temp;
        }
        newlast.next = null;
        head =newhead;
        return newhead;

    }

    public int dayOfYear(String date) {
        boolean isLunerYear = false;
        int year = Integer.parseInt(date.substring(0,4));
        if(year % 4 == 0 && year%100 !=0){
            isLunerYear = true;
        }
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int[] monthdays = {31,30,31,30,31,30,31,31,30,31,30,31};
        int ans = 0;
        for(int i =0;i<month;i++){
            ans = ans+monthdays[i];
            if(i == 1 && isLunerYear == true){
                ans -=1;
            }
        }
        ans += day;
        return ans;
    }
}
