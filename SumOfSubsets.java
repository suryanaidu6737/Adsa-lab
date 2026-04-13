import java.util.*;

class SumOfSubsets {

    int n;
    int[] w;     // elements
    int[] x;     // solution array
    int M;       // target sum

    SumOfSubsets(int n, int[] w, int M) {
        this.n = n;
        this.w = w;
        this.M = M;
        x = new int[n];
    }

    void subset(int sum, int k) {

        if (sum == M) {
            System.out.print("Subset: ");
            for (int i = 0; i < k; i++) {
                if (x[i] == 1)
                    System.out.print(w[i] + " ");
            }
            System.out.println();
            return;
        }

        if (k == n || sum > M)
            return;

        // Include element
        x[k] = 1;
        subset(sum + w[k], k + 1);

        // Exclude element
        x[k] = 0;
        subset(sum, k + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] w = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int M = sc.nextInt();

        SumOfSubsets obj = new SumOfSubsets(n, w, M);

        System.out.println("\nSubsets with given sum:\n");
        obj.subset(0, 0);
    }
}
