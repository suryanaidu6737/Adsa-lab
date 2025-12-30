class MaxHeap
{
	int[] arr;
	int maxsize;//totat no:of elements in array
	int heapsize;
	maxHeap(int size)
	{
		maxsize=size;
		heapsize=0;
		arr=new int[maxsize];
	}
	int parent(int x)
	{
		return (x-1)/2;
	}
	int lchild(int x)
	{
		return 2*x+1;
	}
	int rchild(int x)
	{
		return 2*x+2;
	}
	int getmax()
	{
		return arr[0];
	}
	int cursize()
	{
		return heapsize;
	}
	void insert(int x)
	{
		if(heapsize==maxsize)
		{
			System.out.println("Overflow");
			return;
		}
		int i=heapsize;
		arr[heapsize]=x;
		heapsize++;
		while(i!=0&&arr[parent(i)]<arr[i])
		{
			int temp=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=temp;
			i=parent(i);
		}
	}
	void remove()
	{
		if(maxsize==0)
		{
			System.out.println("No heap exists");
			return;
		}
		if(heapsize==1)
		{
			heapsize--;
		}
		else
		{
			arr[0]=arr[heapsize-1];
			heapsize--;
			heapify(0);
		}
	}
	void heapify(int x)
	{
		int left=lchild(x);
		int right=rchild(x);
		int largest=x;
		if(l<heapsize&&arr[largest]<arr[left])
		{
			largest=left;
		}
		if(l<heapsize&&arr[largest]<arr[right])
		{
			largest=right;
		}
		if(largest!=x)
		{
			int temp=arr[x];
			arr[x]=arr[largest];
			arr[largest]=temp;
			heapify(largest);
		}
	}
	public static void main(String[] args)
	{
		MaxHeap obj=new MaxHeap(10);
		int[] arr={6,9,5,4,10};
		for(int i:arr)
		{
			insert(i);
		}
		System.out.println("The current size of the heap is " + obj.curSize());
		System.out.println("The current maximum element is " + obj.getMax());
		obj.remove();
		System.out.println("The current size of the heap is " + obj.curSize());
		System.out.println("The current maximum element is " + obj.getMax());
	}
		
}


		
		
	
			 
