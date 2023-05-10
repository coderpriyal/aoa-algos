import java.util.*;
import java.lang.Math;

public class colourGraph 
{
    public static final int numNodes = 4;
    public static  int[] color;

    public static boolean isSafeToColor(int v, int numNodes, int[][] graphMatrix, int[] color, int c){
        for (int i = 0; i < numNodes; i++)
            if (graphMatrix[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    public static boolean graphColorUtil(int[][] graphMatrix, int m, int[] color, int v, int numNodes){
        if (v == numNodes)
            return true;

        for (int i = 1;i <= m; i++){
            if (isSafeToColor(v, numNodes, graphMatrix, color, i)){
                color[v] =i;
                if (graphColorUtil(graphMatrix, m, color, v + 1, numNodes))
                    return true;
                color[v] = 0;
            }
        }

        return false;
    }

    public static void printColoringSolution(int color[])
    {
        System.out.println("Color schema for vertices are: ");
        for (int i = 0; i < color.length; i++)
            System.out.print(color[i]+" ");
    }

    public static boolean graphColoring(int[][] graphMatrix, int m, int numNodes){
        color = new int[numNodes];
        Arrays.fill(color,0);

        if (!graphColorUtil(graphMatrix, m, color, 0, numNodes)){
            System.out.println(
                "Color schema not possible");
            return false;
        }

        printColoringSolution(color);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int numNodes = sc.nextInt();
        int graph[][] = new int[numNodes][numNodes];
        System.out.println("If edge exists, enter '1' otherwise enter '0'");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if(i==j){
                    graph[i][j]=1;
                }else{
                    System.out.print("Edge for "+i+","+j+": ");
                    graph[i][j] = sc.nextInt();
                }
            }
        }
       
        System.out.print("Enter the number of colours: ");
        int numColours = sc.nextInt();

        long start = System.nanoTime();
        graphColoring(graph, numColours, numNodes);
        long end = System.nanoTime();
        long execution = end - start;
    System.out.println("\n Execution time: " + execution + " nanoseconds");
        sc.close();
    }
}
