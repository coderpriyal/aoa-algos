import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class MinMax
{
    public static void main(String[]args)
    {
            int n;
          Random rand = new Random();
         Scanner sc = new Scanner(System.in);
System.out.println("Enter the size of the array:\n");
n = sc.nextInt();
int arr[] = new int[n];
System.out.println("The random array generated is:\n");
for(int i=0;i<n;i++)
{
arr[i] = rand.nextInt(300);
System.out.println(arr[i]+" ");
}
System.out.println(" ");
long startTime = System.nanoTime();
int[] result = findMinMax(arr);
long endTime   = System.nanoTime();
long finalTime = endTime - startTime;
System.out.println("");
System.out.println("min is:"+ result[0]);
System.out.println("Max is: " + result[1]);
System.out.println("Execution time: " + finalTime +"nanoseconds" );

 }
 public static int[] findMinMax(int[] arr) {
    int[] result = new int[2];
    if (arr == null || arr.length == 0) {
        return result; // empty array
    }

    result[0] = arr[0]; // min
    result[1] = arr[0]; // max

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < result[0]) {
            result[0] = arr[i]; // new min
        } else if (arr[i] > result[1]) {
            result[1] = arr[i]; // new max
        }
    }

    return result;

}
}
