import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class MinMaxRecursive
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
        A[i]=rand.nextInt(100);
        System.out.print(A[i]+" "); 
    }
    System.out.println("");
    long start = System.nanoTime();
    int min= MinRec(A, n);
    int max= MaxRec(A, n);
    System.out.println("The min is: "+min+" and the max is: "+max);
    long end = System.nanoTime();
    long execution = end - start;
    System.out.println("Execution time: " + execution + " nanoseconds");
    }

public static int MinRec(int A[] ,int n)
{
    if (n== 1)
     return A[0];
     return Math.min(A[n-1], MinRec(A, n-1));
}
public static int MaxRec(int A[], int n)
{
    if(n == 1)
    return A[0];
    return Math.max(A[n-1], MaxRec(A, n-1));
}
}


