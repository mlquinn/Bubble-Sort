/*
*@author Michael Quinn
*@class bubbleSort
*@coreConcept The core concept for this lesson is the ability to perform the Bubble Sort algorithm.
*@date 1/30/18
*/
import java.util.Scanner;
public class bubbleSort {
   public static void main (String[] args){ 
      int list[] = new int[20];
      Scanner in = new Scanner (System.in);
      
      
      //Repeat program
      while (true){
         //Initialize the array
         for(int i = 0; i < list.length; i++){
            list[i] = (int)(1000.0 * Math.random());
         }
         //Print the unsorted array
         System.out.println("Unsorted array:");
         printArray(list);
         
         //Print array after each pass (not swap)
         bubbleSort(list);
         System.out.println("Sorted array: ");
         printArray(list);
         System.out.println("Run again? y/n");
         if(in.next().charAt(0) == 'n'){
            System.out.println("Goodbye.");
            System.exit(0);
         }
         
      }
      
   }
   
   //Bubble Sort method
  public static void bubbleSort(int arr[]){
   for (int i = 0; i < (arr.length - 1); i++){
      for (int k = 0; k < (arr.length - i - 1); k++){
         if (arr[k] > arr[k +1]){
            int temp = arr[k];
            arr[k] = arr[k+1];
            arr[k+1] = temp;
         }
      }
   System.out.println("pass: " + i);
   printArray(arr);
   }
  }
   
   //Print Array method
   public static void printArray (int list[]){
      System.out.print("\t");
      for (int i = 0; i < list.length - 1; i++){
         System.out.print(list[i] + ", ");
      }
      System.out.print(list[list.length - 1] + ".\n");
   }
}