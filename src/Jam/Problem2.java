package Jam;

import java.util.*;
public class Problem2 {
    final static  int target = 1000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[][] data = new Integer[4][3];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<3;j++){
                for(int c = 0;c<4;c++){
                    data[c][j] = sc.nextInt();
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            color(data);
            }
        }
        public static void color(Integer[][] data){
            int col =3;
            int row =4;
            int[] ints = new int[4];
            Integer minSum = 0;
            for(int c =0;c<4;c++){
                if(target-minSum<=0){
                    break;
                }
                int intC = Math.min(Collections.min(Arrays.asList(data[c])),target-minSum);
                ints[c] = intC;
                minSum = intC + minSum;
            }
            if(minSum<target){
                System.out.println("IMPOSSIBLE");
                return;
            }
            for(int i = 0;i<3;i++){
                System.out.print(ints[i]+ " ");
            }
            System.out.println(ints[3]);

        }
}
