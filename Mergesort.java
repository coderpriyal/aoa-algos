import java.util.Scanner;
import java.util.*;
import java.lang.Math;

  class Mergesort
 {
    public static void main(String[]args)
    {
        int n ;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:\n");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("The random generated array:\n");
        for(int i = 0;i<n;i++)
        {
            arr[i]=rand.nextInt(10000);
            System.out.print(arr[i]+ " ");
        }
        System.out.print("");
        long starttime = System.nanoTime();
        sort(arr,0,n-1);
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
    static void merge(int arr[],int l,int m,int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        int A[] = new int[n1];
        int B[] = new int[n2];
        for (int i = 0; i < n1; ++i)
        A[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
        B[j] = arr[m + 1 + j];
        int i = 0, j = 0;int k = l;
        while (i < n1 && j < n2) 
        {
            if (A[i] <= B[j]) 
            {
                arr[k] = A[i];
                i++;
            }
            else
            {
                arr[k] = B[j];
                j++;               
            }
            k++;
        }       
 }
 static void sort(int arr[], int l, int r)
{
if (l < r) 
{
    int m = l + (r - l) / 2;
    sort(arr, l, m);
    sort(arr, m + 1, r);
    merge(arr, l, m, r);
}
}
}
