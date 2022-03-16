package ArrayAndString;
import java.util.*;
import java.math.*;
public class Solution {
    public class ListNode { int val;ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
/*        //solution1
        System.out.println(solution1());*/


        //solution2
        //Given two strings, write a method to decide if one is a permutation of the other
/*        String s2a = sc.next();
        String s2b = sc.next();
        System.out.println(solution2(s2a,s2b));*/

        //solution5
        //One Away: There are three types of edits that can be performed on strings: insert a character,
        //remove a character, or replace a character. Given two strings, write a function to check if they are
        //one edit (or zero edits) away
//        String s5a = sc.next();
//        String s5b = sc.next();
//        System.out.println(solution5(s5a,s5b));



//        int[][] setzeros11 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        setZeroes(setzeros11);



    }

    public static boolean solution1(){
        Scanner sc = new Scanner(System.in);
        HashMap h1 = new HashMap<>();
        String str = sc.next();
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            if(h1.containsKey(c)){
                return false;
            }
            h1.put(c,c);
        }
        return true;
    }

    //Solution #2: Check if the two strings have identical character counts.
    public static boolean solution2(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        int[] a1 = new int[128];
        int[] b1 = new int[128];
        for(int i=0;i<a.length();i++){
            a1[(int)a.charAt(i)]++;
            b1[(int)b.charAt(i)]++;
        }
        for(int i =0;i<256;i++){
            if(a1[i]!=b1[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean solution5(String first,String second){
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        //a is the shorter one
        String a = first.length()<second.length()?first:second;
        String b = first.length()<second.length()?second:first;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while(index1<a.length() && index2<b.length()){
            if(a.charAt(index1) == b.charAt(index2)){
                index1++;
                index2++;
            }else
            {
                if(a.length() == b.length()){
                    if(foundDifference){
                        return false;
                    }
                    foundDifference = true;
                }else{
                    if(index1 != index2){
                        return false;
                    }
                    index2++;
                }
            }
        }
        return true;
    }

    public static void setZeroes(int[][] matrix) {
        List<int[]> indexes = new LinkedList<>();
        int n = matrix[0].length;
        int m = matrix.length;

        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    indexes.add(temp);
                }
            }
        }
        for(int i=0;i<indexes.size();i++){
            for(int col =0;col<n;col++){
                matrix[indexes.get(i)[0]][col] = 0;
            }
            for(int row =0;row <m;row++){
                matrix[row][indexes.get(i)[1]] = 0;
            }
        }
    }

}
