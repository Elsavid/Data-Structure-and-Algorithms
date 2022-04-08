import java.util.*;
public class Jam {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rows = new int[n];
        int[] columns = new int[n];
        for(int i = 0;i<n;i++){
            rows[i] = sc.nextInt();
            columns[i] = sc.nextInt();
        }
        for(int i = 0; i < n;i++){
            System.out.println("Case #"+(i+1)+":");
            System.out.print("..");
            for(int column = 1;column<columns[i];column++){
                System.out.print("+-");
                if(column == columns[i]-1){
                    System.out.print("+");
                }
            }
            System.out.println();
            System.out.print("..");
            for(int column = 1;column<columns[i];column++){
                System.out.print("|.");
                if(column == columns[i]-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            for(int row = 1;row<rows[i];row++){
                for(int column = 0;column<columns[i];column++){
                    System.out.print("+-");
                    if(column == columns[i]-1){
                        System.out.print("+");
                    }
                }
                System.out.println();
                for(int column = 0;column<columns[i];column++){
                    System.out.print("|.");
                    if(column == columns[i]-1){
                        System.out.print("|");
                    }
                }
                System.out.println();
                if(row == rows[i]-1){
                    for(int column = 0;column<columns[i];column++){
                        System.out.print("+-");
                        if(column == columns[i]-1){
                            System.out.print("+");
                            System.out.println();
                        }
                    }
                }
//                System.out.println();
            }
        }

    }

}
