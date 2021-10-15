/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf;

/**
 *
 * @author User
 */
public class ADF {

   static void  bubbleSortD_withoutFlag(int[] arr){
   int n = arr.length;
   int temp=0;
   for (int j =0 ; j<(n-1); j++){
   if(arr[j-1] > arr[j]){
   temp = arr[j-1];
   arr[j-1]=arr[j];
   arr[j]=temp;
   }
   }
   
   }
    public static void main(String[] args) {
        
        int arr[]={4,12,44,26,8,6};
        System.out.println("Array Before Bubble Sort");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
         bubbleSortD_withoutFlag(arr);
        System.out.println("Array after Bubble Sort");
        for (int i=0 ; i<arr.length; i++){
            System.out.println(arr[i] +"");
        }
    }
    
}
