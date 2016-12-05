import java.util.Scanner;
import java.util.StringTokenizer;

public class TreeRecovery {
	
	private Node root = null;
	private String inOrder;
	
	public TreeRecovery(String order){
		inOrder = order;
	}
	// inserts node in proper place, returns root
	public void insert(Character ch){
		Node node = new Node(ch);
		if (root == null){
			root = node;
		} else {
			insert(root, node);
		}
	}
	
	public void insert(Node currentNode, Node node){
		if (node.lessThan(currentNode)){
			if (currentNode.left == null){
				currentNode.left = node;
				return;
			} else {
				insert(currentNode.left, node);
			}
		} else {
			if (currentNode.right == null){
				currentNode.right = node;
				return;
			} else {
				insert(currentNode.right, node);
			}
		}
	}
	
	public String postOrder(){
		return postOrder(root, "");
	}
	
	public String postOrder(Node node, String post){
		if (node == null)
			return post;
		else{
			post = postOrder(node.left, post);
			post = postOrder(node.right, post);
			post += node.ch;
			return post;
		}
	}
	
	public class Node{
		public Character ch;
		public Node right;
		public Node left;
		
		private Node(Character ch){
			this.ch = ch;
			right = null;
			left = null;
		}
		
		public boolean lessThan(Node node){
			if (inOrder.indexOf(this.ch) < inOrder.lastIndexOf(node.ch))
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()){
			StringTokenizer line = new StringTokenizer(sc.nextLine());
			String preOrder = line.nextToken();
			String inOrder = line.nextToken();
			TreeRecovery tree = new TreeRecovery(inOrder);
			for (int i = 0; i < preOrder.length(); i++){
				tree.insert(preOrder.charAt(i));
			}
			System.out.println(tree.postOrder());
		}
		sc.close();
	}

}
