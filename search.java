/*
*@author Michael Quinn
*@class bubbleSort
*@coreConcept The core concept for this lesson is the ability to perform Linear and Binary searches.
*@date 3/6/18
*/
import java.util.InputMismatchException;

import java.util.Scanner;
public class search{
   public static void main (String[] args){
      int list [] = new int [20];
      Scanner in = new Scanner (System.in);
      int find, result = -1;
      char run, searchType;
      //Repeat
      while (true){
      
         //initalize array
         for(int i = 0; i  < list.length; i++){
            list[i] = (int)(1000.0 * Math.random());
         } 
         System.out.println("Unsorted array: ");
         printArray(list);
         //prompt search
         System.out.println("Begin search? y/n");
         run = in.next().charAt(0);
         if (run == 'y'){
            try{
               System.out.println("{L}inear or {B}inary Search?");
               searchType = in.next().charAt(0);
               System.out.println("Please enter your search item.");
               find = in.nextInt();
               
               if (searchType == 'b' || searchType == 'B'){
                  bubbleSort(list);
                  System.out.print("Searching");
                  result = binarySearch(find, list, 0, list.length + 1);
               }
               else if (searchType == 'l' || searchType == 'L'){
                  result = linearSearch(find, list, 0);
               }
                //if the search fails
               if (result == 1){
                  System.out.println("No results found.");
               }
               //If the search is successful
               else if (result == 0){
                  System.out.println("\n" + find + " was found!");
               }
            }
            catch(InputMismatchException ex) {
               System.out.println("\nInvalid input! Please enter a valid number.\n");
               in.next();
            }
            catch (ArrayIndexOutOfBoundsException ex){
               System.out.println("\nIndex out of bounds. Item not found.");
               result = 1;
            }
            catch (StackOverflowError ex) {
               System.out.println("\nStack Overflow Error. Item not found.");
            }
         }
         else if (run == 'n'){
            System.out.println("Goodbye.");
            System.exit(0);
         }
         else {
            in.nextLine();
         }
      }
   }
   //Binary search
   public static int binarySearch(int find, int arr[], int low, int high){
      System.out.print(". ");
      int mid = low + (high-1)/2;
      if (find == arr[mid])
         return 0;
      else if (find > arr[mid])
         return binarySearch(find, arr, mid + 1, high);
      else if (find < arr[mid]){
         return binarySearch(find, arr, low, mid - 1);
      }
      else
         return 1;
   }
   //Linear search
   public static int linearSearch(int find, int arr[], int index){
      //Step through list looking for item
      if (arr[index] == find){
         return 0;
      }
      else if (index >= arr.length){
         return 1;
      }
      else{
         index++;
         return linearSearch(find, arr, index);
      }
   }
  //Bubble Sort method
  public static void bubbleSort(int arr[]){
   System.out.println("Sorting the list...");
   for (int i = 0; i < (arr.length - 1); i++){
      for (int k = 0; k < (arr.length - i - 1); k++){
         if (arr[k] > arr[k +1]){
            int temp = arr[k];
            arr[k] = arr[k+1];
            arr[k+1] = temp;
         }
      }
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