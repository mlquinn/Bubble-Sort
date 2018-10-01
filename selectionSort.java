/*
*@author Michael Quinn
*@class selectionSort
*@coreConcept The core concept for this lesson is the ability to perform the Selection Sort algorithm.
*@date 1/30/18
*/
import java.util.ArrayList;
import java.util.Scanner;

public class selectionSort {
   public static void main(String[] args) {
      int unsorted [] = new int[20];
      char flag;
      Scanner input = new Scanner (System.in);
      
      
      
      while(true){
         try {
               //Initalize the array
            for (int i = 0; i < unsorted.length; i++){
              unsorted[i] = (int)(1000.0 * Math.random());
            }
            //Print the unsorted array
            System.out.println("Unsorted array: ");
            printArray(unsorted);
            System.out.println("list size: " + unsorted.length);
            //Sort the unsorted array
            selectionSort(unsorted);
            //Print the sorted array
            System.out.println("Sorted array: ");
            printArray(unsorted);
            //Check to see if user wants to continue
            System.out.println("Run again? (y/n)");
             if (input.next().charAt(0) == 'n'){
               System.out.println("Goodbye.");
               System.exit(0);
             }
               
            
         }
         catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index out of bounds error.");
            e.printStackTrace();
         }
      }
   }
   
   public static void selectionSort (int list[]){
      int minimum;
      //Move through the unsorted array
      for (int unsortPos = 0; unsortPos < list.length; unsortPos++){
         minimum = unsortPos;
         //find the minimum element in unsorted array
         for (int currentMin = unsortPos; currentMin < list.length; currentMin++){
            //System.out.println("min: " + minimum + " cMin: " + currentMin);
            if(list[currentMin] < list[minimum])
               minimum = currentMin;
         }
           //Swap the minimum element
           int temp = list[minimum];
           list[minimum] = list[unsortPos];
           list[unsortPos] = temp;
           System.out.println("Pass " + unsortPos + ": ");
           printArray(list);
       } 
    }
   
   
   
   public static void printArray(int list[]) {
      for(int i = 0; i < list.length - 1; i++){
      //if (i == 10) System.out.println();
         System.out.print(list[i] + ", ");
      }
      System.out.print(list[(list.length - 1)] + ".\n");
   }
   
}
