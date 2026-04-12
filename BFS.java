import java.util.*;
class BFS
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
		Queue<Integer> q=new LinkedList<>();
		System.out.print("enter source");
		int start=sc.nextInt();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty())
		{
			int v=q.poll();
			System.out.print(v+" ");
			for(int i=0;i<n;i++)
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
	
