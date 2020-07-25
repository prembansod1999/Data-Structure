import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data = data;
		left=right=null;
	}
}
public class BinaryTree
{
	Node root;
	public BinaryTree()
	{
		root = null;
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Element");
		int data = sc.nextInt();
		
		if(root == null)
		{
			root = new Node(data);
			return;
		}
		
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			Node p = (Node)q.remove();
			if(p.left!=null)
			{
				q.add(p.left);
			}
			else
			{
				p.left = new Node(data);
				q = null;
				return;
			}
			if(p.right!=null)
			{
				q.add(p.right);
			}
			else
			{
				p.right = new Node(data);
				q = null;
				return;
			}
		}
		q=null;
	}
	public void preorder()
	{
		System.out.print("Preoreder with recursion = ");
		preorder(root);
		System.out.println();
	}
	public void inorder()
	{
		System.out.print("Inoreder with recursion = ");
		inorder(root);
		System.out.println();
	}
	public void inorder(Node p)
	{
		if(p!= null)
		{
			inorder(p.left);
			System.out.print(p.data+" ");
			inorder(p.right);
		}
	}
	public void inorderWithoutRecursion()
	{
		Node p = root;
		System.out.print("Inoreder without recursion = ");
		Stack s = new Stack();
		while(true)
		{
			while(p!=null)
			{
				s.push(p);
				p = p.left;
			}
			if(s.empty())
				break;
			p = (Node) s.pop();
			
			System.out.print(p.data+" ");
			p = p.right;
		}
		s = null;
		p = null;
		System.out.println();
	}
	public void preorderWithoutRecursion()
	{
		System.out.print("Preoreder without recursion = ");
		Node p = root;
		Stack s = new Stack();
		while(true)
		{
			while(p!=null)
			{
				System.out.print(p.data+" ");
				s.push(p);
				p = p.left;
			}
			if(s.empty())
				break;
			p = (Node)s.pop();
			p = p.right;
		}
		System.out.println();
		s = null;
		p = null;
	}
	public void preorder(Node p)
	{
		if(p!=null)
		{
			System.out.print(p.data+" ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	public void postorder()
	{
		System.out.print("Postoreder with recursion = ");
		postorder(root);
		System.out.println();
	}
	public void postorder(Node p)
	{
		if(p!=null)
		{
			postorder(p.left);
			postorder(p.right);
			System.out.print(p.data+" ");
		}
	}
	public void postorderWithoutRecursion()
	{
		System.out.print("Postoreder without recursion = ");
		Stack s = new Stack();
		Node p = root;
		Node q = null;
		do
		{
			while(p!=null)
			{
				s.push(p);
				p = p.left;
			}
			while((p==null)&&!(s.empty()))
			{
				p = (Node)s.peek();
				if((p.right == null)||(p.right==q))
				{
					System.out.print(p.data+" ");
					s.pop();
					q = p;
					p = null;
				}
				else
				{
					p = p.right;
				}
			}
		}while(!s.empty());
		System.out.println();
	}
	public void levelOrder()
	{
		System.out.print("Level order = ");
		Node p = null;
		Queue q = new LinkedList();
		if(root == null) return;
		q.add(root);
		
		while(!q.isEmpty())
		{
			p = (Node) q.remove();
			System.out.print(p.data+" ");
			if(p.left!=null) q.add(p.left);
			if(p.right!=null) q.add(p.right);
		}
		q = null;
		System.out.println();
	}
	public void print()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("1.Preorder\n2.Inorder\n3.PostOrder\n4.Level order");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: preorder();
				preorderWithoutRecursion();
				break;
			case 2: inorder();
				inorderWithoutRecursion();
				break;
			case 3: postorder();
				postorderWithoutRecursion();
				break;
			case 4: levelOrder();
				break;
			default: System.out.println("Invalid choice");
		}
	}
	public void findMax()
	{
		System.out.println("Maximum Number in Tree = "+findMax(root));
		System.out.println("Maximum Number in Tree using level order = "+findMaxUsingLevelOrder());
	}
	public int findMax(Node p)
	{
		int max = 0;
		int root_data = 0,left = 0,right = 0;
		if(p!=null)
		{
			root_data = p.data;
			left = findMax(p.left);
			right = findMax(p.right);
		}
		
		if(left>right)
			max = left;
		else
			max = right;
		
		if(root_data>max) max = root_data;
		
		return max;
	}
	public int findMaxUsingLevelOrder()
	{
		Node p = null;
		int max = Integer.MIN_VALUE;
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			p =(Node) q.remove();
			if(max < p.data)
			{
				max = p.data;
			}
			if(p.left!=null)
			{
				q.add(p.left);
			}
			if(p.right!=null)
			{
				q.add(p.right);
			}
		}
		q = null;
		return max;
	}
	public void search()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int inp = sc.nextInt();
		System.out.print("With recursion = ");
		if(search(root,inp))
		{
			System.out.println("Number found");
		}
		else
		{
			System.out.println("Number not found");
		}
		System.out.print("Without recursion = ");
		if(search(inp))
		{
			System.out.println("Number found");
		}
		else
		{
			System.out.println("Number not found");
		}

	}
	public boolean search(int data)
	{
		Node p = null;
		Queue q = new LinkedList();
		q.add(root);
		boolean flag = false;
		while(!q.isEmpty())
		{
			p =(Node) q.remove();
			if(p.data == data)
			{
				flag = true;
				break;
			}
			if(p.left!=null) q.add(p.left);
			
			if(p.right!=null) q.add(p.right);
		}
		return flag;
	}
	public boolean search(Node p, int data)
	{
		boolean temp;
		if(p == null)
		{
			return false;
		}
		else
		{
			if(p.data == data)
			{
				return true;
			}
			else
			{
				temp = search(p.left,data);
				if(temp)
					return true;
				else 
					return search(p.right,data);
			}
		}
	}
	public void size()
	{
		System.out.println("Size of Tree = "+size(root));
		System.out.println("Size of Tree without recursion = "+sizeWithoutRec(root));	
	}
	public int size(Node p)
	{
		if(p==null)
			return 0;
		else
			return 1 + size(p.left) + size(p.right);
	}
	public void sizeWithoutRec(Node p)
	{
		Queue q = new LinkedList();
		q.add(p);
		int size = 0;
		while(!q.isEmpty())
		{
			p = q.remove();
			size++;
			if(p.left!=null) q.add(p.left);
			
			if(p.right!=null) q.add(p.right);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		BinaryTree obj = new BinaryTree();
		int choice = 0;
		do
		{
			System.out.println("1. Insert\n2. Print\n3. Find Maximum Number in Tree\n4. Search\n5. Size\n6. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.insert();
					break;
				case 2: obj.print();
					break;
				case 3: obj.findMax();
					break;
				case 4: obj.search();
					break;
				case 5: obj.size();
					break;
				case 6: return;
			}
		}while(true);
	}
}
