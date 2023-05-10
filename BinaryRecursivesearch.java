import java.util.Scanner;
import java.util.*;
import java.lang.Math;
public class BinaryRecursivesearch
{
    public static void main(String[]args)
    {
    int n;   
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    n = sc.nextInt();
    int A[]= new int [n];
    int low = 0,high = A.length - 1;
    System.out.println("The random generated array is:\n");
    for(int i =0;i<n;i++)
    {
        A[i]=rand.nextInt(300);
        System.out.print(A[i]+" "); 
    }
    System.out.println("");
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
        int answer = recursive(A,x,0,n-1);
        long end = System.nanoTime();
        long execution = end - start;
        if(answer == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
        System.out.println(" "); 
        }  
        System.out.println("Execution time:"+ execution + " nanoseconds ");  
    }
}
public static int recursive(int A[],int x,int low,int high)

{
    
    if(high>=low)
    {
        int mid =low+(high-low)/2;
     if(A[mid]==x)
     return mid;
     if(A[mid]>x)
     return recursive(A, x, low, mid-1);
     return recursive(A, x, high,mid+1);
    }
 
return -1;
}
}
   