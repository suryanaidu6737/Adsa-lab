import java.util.*;
class BfsArrayList
{
	public static void main(String []args){
	Scanner sc=new Scanner(System.in);
	System.out.print("enter no:of vertices:");
	int n=sc.nextInt();
	ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
	for(int i=0;i<n;i++)
	{
		adj.add(new ArrayList<>());
	}
	System.out.print("enter no:of edges:");
	int e=sc.nextInt();
	System.out.println("enter source and destination");
	for(int i=0;i<e;i++)
	{
		int u=sc.nextInt();
		int v=sc.nextInt();
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	boolean visited[]=new boolean[n];
	Queue<Integer> q=new LinkedList<>();
	System.out.print("enter start:");
	int start=sc.nextInt();
	q.add(start);
	visited[start]=true;
	while(!q.isEmpty())
	{
		int node=q.poll();
		System.out.print(node+" ");
		for(int x:adj.get(node))
		{
			if(!visited[x])
			{
				visited[x]=true;
				q.add(x);
			}
		}
	}
}
}
	
