import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class Binarysearch
{
    public static void main(String[]args)
    {
    int n;   
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    n = sc.nextInt();
    int A[]= new int [n];
    System.out.println("The random generated array is:\n");
    for(int i =0;i<n;i++)
    {
        A[i]=rand.nextInt(n);
        System.out.println(A[i]);      
    }
    System.out.println("Sorted array is:\n");

    for(int i =0;i<n-1;i++)
    {
        for (int j=0;j<n-i-1;j++)
        {
            int temp;
            if(A[j]>A[j+1])
            {
                temp =A[j];
                A[j]=A[j+1];
                A[j+1]=temp;
            }

        }
    }
    for(int i=0;i<n;i++)
    {
        System.out.print(A[i]+" ");
    }
    System.out.println(" ");
    System.out.println("Enter the number to be searched:");
    int x = sc.nextInt();
    
    {
        long start = System.nanoTime();
        int answer = iterative(A,x);
        long end = System.nanoTime();
        long execution = end - start;
        if(answer == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
        System.out.println("");
        System.out.println("Execution time:"+ execution + " nanoseconds ");   
        }  
    }
}
public static int iterative(int A[], int x)
{
    int low = 0,high = A.length - 1,mid;
    while (low <= high)
    { 
        mid = (low + high) / 2;
        if (x == A[mid]) 
        {
            return mid;
        }
        else if (x< A[mid])
        {
            high = mid -1;
        }
        else
        {
            low = mid +1;
        }

    }
    return -1;
}
}
