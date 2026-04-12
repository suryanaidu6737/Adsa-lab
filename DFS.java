import java.util.*;
class DFS
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr n value");
		int n=sc.nextInt();
		int adj[][]=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				adj[i][j]=sc.nextInt();
		boolean[] visited=new boolean[n];
		Stack<Integer> q=new Stack<>();
		System.out.print("enter source");
		int start=sc.nextInt();
		q.push(start);
		visited[start]=true;
		while(!q.isEmpty())
		{
			int v=q.pop();
			System.out.print(v+" ");
			for(int i=n-1;i>=0;i--)
			{
				if(adj[v][i]==1 && !visited[i])
				{
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
}
	
