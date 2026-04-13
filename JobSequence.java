import java.util.*;
class Job
{
	int id,deadline,profit;
	Job(int id,int deadline,int profit)
	{
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
}
class JobSequence
{
	public static void jobsequence(Job[] jobs)
	{
		Arrays.sort(jobs,(a,b)->b.profit-a.profit);
		int n=jobs.length;
		boolean[] slot=new boolean[n];
		int result[]=new int[n];
		int totalprofit=0;
		for(Job job:jobs)
		{
			for(int j=job.deadline-1;j>=0;j--)
			{
				if(!slot[j])
				{
					slot[j]=true;
					result[j]=job.id;
					totalprofit+=job.profit;
					break;
				}
			}
		}
		System.out.print("job sequence: ");
		for(int job:result)
		{
			if(job!=0)
				System.out.print(job+" ");
		}
		System.out.println("\nTotal Profit: " + totalprofit);
			
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("enter no:of jobs: ");
		int n=sc.nextInt();
		Job jobs[]=new Job[n];
		System.out.println("enter id,deadline,profit ");
		for(int i=0;i<n;i++)
		{
			int id=sc.nextInt();
			int deadline=sc.nextInt();
			int profit=sc.nextInt();
			jobs[i]=new Job(id,deadline,profit);
		}
		jobsequence(jobs);
	}
}
			
					
