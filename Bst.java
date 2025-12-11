class Node
{
	int key;
	Node left,right;
	Node(int item)
	{
		key=item;
		left=right=null;
	}
}
class Bst
{
	static Node insert(Node root,int key)
	{
		if(root==null)
			return new Node(key);
		if(key==root.key)
			return root;
		else if(key<root.key)
			root.left=insert(root.left,key);
		else
			root.right=insert(root.right,key);
		return root;
	}
	public static Node delete(Node root,int key)
	{
		if(root==null)
			return null;
		if(key<root.key)
			root.left=delete(root.left,key);
		else if(key>root.key)
			root.right=delete(root.right,key);
		else
		{
			if(root.left==null && root.right==null)
				return null;
			else if(root.left==null && root.right!=null)
				return root.right;
			else if(root.left!=null && root.right==null)
				return root.left;
			else
			{
				Node successor=min(root.right);
				key=successor.key;
				root=delete(root.right,successor.key);
			}
		}
		return root;
	}
	public static Node min(Node root)
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		return root;
	}		
    static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
		}
	}
	public static void main(String[] args)
	{
		Node root=null;
		root=insert(root,20);
		root=insert(root,40);
		root=insert(root,30);
		root=insert(root,15);
		inorder(root);
		delete(root,30);
		System.out.println("after delete");
		inorder(root);
	}
}
