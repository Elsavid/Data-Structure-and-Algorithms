package Jam;

import java.util.*;
public class Problem3 {
    final static  int target = 1000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data;
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            data = new int[x];
            for(int j = 0;j<x;j++){
                data[j] = sc.nextInt();
            }
            System.out.print("Case #"+(i+1)+": ");
            solve(data);
        }
    }
    public static void solve(int[] data){
        Arrays.sort(data);
        int sub = 0;
        int cout= 1;
        int preV= data[0];
        for(int i = 1;i<data.length;i++){
            if(preV == data[i]){
                cout++;
                continue;
            }else{
                sub = Math.min(preV,cout+sub);
                cout = 1;
                preV  = data[i];
            }
        }
        sub = Math.min(preV,cout+sub);
        System.out.println(sub);

    }
}
