class Node
{
	int data;
	Node left;
	Node right;
	int h;
	public Node(int x)
	{
		data = x;
		left = right = null;
	}
}
public class Avl
{
	Node root;
	public Avl()
	{
		root = null;
	}
	public void insert()
	{
	}
	public void print()
	{
	}
	public static void main(String[] args)
	{
		Avl obj = new Avl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do
		{
			System.out.println("1.Insert\n2.Print\n3.Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.insert();
					break;
				case 2: obj.print();
					break;
				case 3: return;
				default: System.out.println("Invalid choice");
			}
		}while(true);
	}
}
