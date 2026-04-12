import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int cost[][] = new int[n][n];
        int dist[] = new int[n];
        boolean vis[] = new boolean[n];

        // Input cost matrix
        System.out.println("Enter cost adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // Input source vertex
        System.out.print("Enter source vertex: ");
        int v = sc.nextInt();

        // Initialization
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            vis[i] = false;
        }

        dist[v] = 0;

        // Dijkstra Algorithm
        for (int i = 0; i < n - 1; i++) {

            // Find minimum distance vertex (u)
            int min = Integer.MAX_VALUE;
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!vis[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            vis[u] = true;

            // Update distances
            for (int w = 0; w < n; w++) {
                if (!vis[w] && cost[u][w] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + cost[u][w] < dist[w]) {

                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }

        // Output
        System.out.println("\nVertex \t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
