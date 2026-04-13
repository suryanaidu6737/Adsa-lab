import java.util.*;

class GraphColoring {

    int V;              // number of vertices
    int[] color;        // color array
    int[][] graph;      // adjacency matrix

    // Constructor
    GraphColoring(int V) {
        this.V = V;
        color = new int[V];
        graph = new int[V][V];
    }

    // Check if it's safe to assign color c to vertex v
    boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        }
        return true;
    }

    // Backtracking function
    boolean solveColoring(int v, int m) {

        // Base case: all vertices are colored
        if (v == V)
            return true;

        // Try all colors
        for (int c = 1; c <= m; c++) {

            if (isSafe(v, c)) {

                color[v] = c; // assign color

                // Recur for next vertex
                if (solveColoring(v + 1, m))
                    return true;

                // Backtrack
                color[v] = 0;
            }
        }

        return false; // no color possible
    }

    // Print solution
    void printSolution() {
        System.out.println("Vertex Colors:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Color " + color[i]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        GraphColoring obj = new GraphColoring(V);

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                obj.graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();

        if (obj.solveColoring(0, m)) {
            System.out.println("\nSolution exists:");
            obj.printSolution();
        } else {
            System.out.println("\nNo solution exists.");
        }

        sc.close();
    }
}
