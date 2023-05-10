import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class Quicksort
{
    public static void main(String[]args)
    {
        int n;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:\n");
        n=sc.nextInt();
        int arr[] = new int[n];
        System.out.println("The random array generated is:\n");
        for(int i = 0;i<n;i++)
        {
            arr[i]=rand.nextInt(10000);
            System.out.print(arr[i]+ " ");
        }
        System.out.print("");
        
        long starttime = System.nanoTime();
        quicksort(arr,0,n-1);
        System.out.println(" ");
        System.out.println("The sorted array is:");
        for(int i =0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
            
        }
       
        long endtime= System.nanoTime();
        long execution = endtime-starttime;
        System.out.println(" ");
        System.out.println("Execution time:" + execution + " nanoseconds ");       
    }
    static void swap(int[] arr, int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }
    static int partition(int[] arr, int left,int right)
    {
        int pivot = arr[right];
        int i = left-1;
        for(int j = left ; j<=right-1;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                swap(arr,i,j);

            }
        }
        swap(arr,i+1,right);
        return (i+1);
    }
    static void quicksort(int[]arr,int left,int right)
    {
        if(left<right)
        {
            int p = partition(arr,left,right);
            quicksort(arr,left,p-1);
            quicksort(arr,p+1,right);
        }
    }


}
