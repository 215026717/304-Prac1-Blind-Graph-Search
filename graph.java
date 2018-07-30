import java.io.*;
import java.util.*;

public class graph{
   boolean adjMatrix[][] = new boolean[7][7];
   public void graphCreation(){
      //System.out.println(adjMatrix[0][0]);
      int[] temp = {1,2,4};
   
      for(int i = 0; i < 7;i++){
         if (i == 1){
            temp = new int[2];
            temp[0] = 3;
            temp[1] = 5;
         }
         else if(i == 2){
            temp = new int[1];
            temp[0] = 6;
         }
         else if(i == 4){
            temp = new int[1];
            temp[0] = 5;
         }
         for (int x:temp){
            adjMatrix[i][x] = !adjMatrix[i][x];
         }
         temp = new int[0];
      }
      /*for (boolean a:adjMatrix[4]){
         System.out.print(a);
      }*/
   }
   static Stack<Integer> open = new Stack<Integer>();
   ArrayList<Integer> closed = new ArrayList<Integer>();
   
   public int DFS(int goal, int b){
      //for (int i = b; i < 7;i++){
         if (b == goal){
               return b;
         }
         else{
            //for (boolean x:adjMatrix[i]){
            for (int j = 0; j < 7;j++){
               if (adjMatrix[b][j]){
                  open.push(DFS(goal,j));
                  //DFS(goal,j);
                  open.pop();
               }
            }
            closed.add(b);
         }
      //}
      //open.pop();
      return b;
   }
   
   public void DFS(int goal){
      /*if (goal == 0){
         int[] a = {0};
         return a;
      }
      else{
         closed.add(0);
      }*/
      graphCreation();
      open.push(0);
      for (int i = 0; i < 7;i++){
         /*if (i == goal){
            closed.add(open.pop());
            return i;
         }
         else{*/
            //closed.add(i);
            //for (boolean x:adjMatrix[i]){
            for (int j = 0; j < 7;j++){
               if (adjMatrix[i][j]){
                  //if (goal != j){
                     open.push(j);
                     DFS(goal,j);
                     //open.pop();
                  //}
               }
            }
         //}
      }
      
   }
   public static void main(String args[]){
      graph prac1 = new graph();
      prac1.DFS(6);
      while (!(prac1.open.empty())){
         prac1.open.pop();
      }
   }
}