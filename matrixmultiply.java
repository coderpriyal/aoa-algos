import java.util.*;
import java.lang.Math;
public class matrixmultiply
{
    
  static int[][] dp = new int[100][100];
 
  // Function for matrix chain multiplication
  static int matrixChainMemoised(int[] p, int i, int j)
  {
    if (i == j) 
    {
      return 0;
    }
    if (dp[i][j] != -1) 
    {
      return dp[i][j];
    }
    dp[i][j] = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) 
    {
      dp[i][j] = Math.min(
        dp[i][j], matrixChainMemoised(p, i, k)
        + matrixChainMemoised(p, k + 1, j)
        + p[i - 1] * p[k] * p[j]);
    }
    return dp[i][j];
  }
 
  static int MatrixChainOrder(int[] p, int n)
  {
    int i = 1, j = n - 1;
    return matrixChainMemoised(p, i, j);
  }
 
  // Driver Code
  public static void main (String[] args)
  {
 
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the no. of  values as input - ");
    int N=sc.nextInt();
    System.out.print("Enter the  values:  ");
    int arr[];
    arr=new int[N];
    
    for(int i=0; i<N; i++)
    {
        
        arr[i]=sc.nextInt();
    }
    // int arr[] = { 1, 2, 3, 4 };
    // int N= arr.length;
 
    for (int[] row : dp)
      Arrays.fill(row, -1);
 
    System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, N));
  }

}
