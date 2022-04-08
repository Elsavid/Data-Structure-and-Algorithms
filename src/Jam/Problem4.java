package Jam;

import java.util.*;
public class Problem4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] f ; //x models
        ArrayList<Integer>[] adj ;

        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            f = new long[x+1];
            adj = new ArrayList[x+1];
            for(int j = 1;j<=x;j++){ // x models
                f[j] = sc.nextInt();
            }
            for(int j = 1;j<=x;j++){
                int temp = sc.nextInt(); //1 j = 2 j->temp then reverse temp visited j .
                if(adj[temp] == null){
                    adj[temp] = new ArrayList();
                }
                adj[temp].add(j);
            }


            System.out.print("Case #"+(i+1)+": ");

            solve2(f,adj,x);
        }
    }
    public static void solve2(long[] f,ArrayList<Integer>[] adj, int x){
//        for(int i = 0;i<adj.length;i++){
//            for(int j = 0;adj[i]!= null && j<adj[i].size();j++){
//                System.out.println("node " + i+adj[i]+ " :" + adj[i].get(j)+ " ");
//            }
//            System.out.println( );
//        }
        long[] tonglu = new long[x+1];
        long[] remaining= new long[x+1];
        for(int i = x;i>0;i--){
            int size = adj[i] != null ? adj[i].size():0;
//            int sumC = 0;
//            int minSub = Integer.MAX_VALUE;
            if(size == 0){
                tonglu[i] = f[i];
                continue;
            }
            if(size == 1){
                tonglu[i] = Math.max(tonglu[adj[i].get(0)],f[i]) ;
                remaining[i] = remaining[adj[i].get(0)];
                continue;
            }
            long minTongluVal = Integer.MAX_VALUE;
            long sumRemainingVal = 0;
            int minTongluNode = 0;
            for(int j = 0; j<size;j++){
                //find min tonglu index and value form adj
                if(tonglu[adj[i].get(j)] < minTongluVal ){
                    minTongluNode = adj[i].get(j);
                    minTongluVal = tonglu[adj[i].get(j)];
//                    System.out.println("node " + i+ " current Min " + minTongluVal);
                }
//                minTongluVal = Math.min(tonglu[adj[i].get(j)],minTongluVal);
                sumRemainingVal = sumRemainingVal + remaining[adj[i].get(j)]+tonglu[adj[i].get(j)];
            }
            tonglu[i] = Math.max(minTongluVal,f[i]);
            remaining[i] = sumRemainingVal - tonglu[minTongluNode];
//            System.out.println("node " + i+ " minTongluVal " + minTongluVal);
//            System.out.println("node " + i+ " f " + f[i]);
//            System.out.println("node " + i+ " tonglu " + tonglu[i]);

        }
        long sum0 = 0;
        for(int j = 0; j<adj[0].size();j++){
            sum0 = sum0 + remaining[adj[0].get(j)]+tonglu[adj[0].get(j)];
        }
        System.out.println(sum0);
        for(int i = 0;i<adj.length;i++){
//            System.out.println("node " + i+ " remaining " + remaining[i]);
//            System.out.println("node " + i+ " tonglu " + tonglu[i]);
        }
    }
}
