import java.util.*;
import java.lang.Math;

public class BinaryIterativesearch
{
    public static void main(String[]args)
    {
        int n = 5000;   
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        
        for(int size =1;size<=n;size++)
        {
            // input elements in array of length size
            int A[]= new int [size];
            for(int i = 0; i < size; i++) A[i]=rand.nextInt(5000);
            
            //sorting
            for(int k =0;k<size-1;k++)
            {
                for (int j=0;j<size-k-1;j++)
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
            
            //binary search and exucution Runtime
            int x = A[0];
            long start = System.nanoTime();
            int answer = iterative(A,x);
            long end = System.nanoTime();
            long execution = end - start;
            System.out.print(execution + ", ");
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