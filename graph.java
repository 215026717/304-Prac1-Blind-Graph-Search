import java.io.*;
import java.util.*;

public class graph{
   boolean adjMatrix[][] = new boolean[7][7];
   public void graphCreation(){
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
   }
   static Stack<Integer> open = new Stack<Integer>();
   static ArrayList<Integer> closed = new ArrayList<Integer>();
   static Queue<Integer> openBF = new LinkedList<>();
   
   public void DFS(int goal, int b){
      if (b != goal){
         open.push(b);
      }//for (boolean x:adjMatrix[i]){
      for (int j = 0; j < 7;j++){
         if (adjMatrix[b][j]){
            if (!(closed.contains(j))){
               if (j == goal){
                  open.push(j);
                  break;
               }
               DFS(goal,j);
               if (open.peek() == goal)
                  break; //outerloop;
               closed.add(open.pop());
               
            }
         }
      }
   }
   
   public void BFS(int goal, int x){
      for (int i = 0;i < 7;i++){
         if (adjMatrix[x][i]){
            if (i == goal){
               open.push(i);
               open.push(x);
               break;
            }
            if (!(closed.contains(i)))
               openBF.add(i);
            
         }
      }
      closed.add(x);
      if (open.empty())
         BFS(goal,openBF.remove());
      else{
         while (open.peek() != 0){
            for (int i = x; i >= 0;--i){
               if (adjMatrix[i][x]){
                  open.push(i);
               }
            }
         }
      }      
   }
   
   public static void main(String args[]){
      graph prac1 = new graph();
      prac1.graphCreation();
      prac1.BFS(6,0);
      while (!(prac1.open.empty())){
         System.out.println(prac1.open.pop());
      }
   }
}