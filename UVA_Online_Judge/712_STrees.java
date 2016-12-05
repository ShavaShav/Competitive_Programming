import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class STrees {
	private Node root = null;
	
	public void buildTree(char[] leaves){
		Queue<Node> parents = new LinkedList<Node>();
		// for each leaf value, create node and add to a parent
		for (int i = 0; i < leaves.length; i++){
			Node node = new Node('X');	// composite node
			node.left = new Node(leaves[i]);
			node.right = new Node(leaves[++i]);
			parents.offer(node);
		}
		// build tree from ground up until hit root
		while (parents.size() > 1){
			Queue<Node> grandParents = new LinkedList<Node>();
			while (!parents.isEmpty()){ // add parents to gps
				Node node = new Node('X'); // not a leaf
				node.left = parents.poll();
				node.right = parents.poll();
				grandParents.offer(node);
			}
			parents = grandParents;
		}
		root = parents.poll(); //the ultimate grandparent is the root
	}
	
	public char find(char[] vva, Queue<Integer> queue){
		return find(vva, root, queue);
	}
	
	// queue must contain order of vva in tree (eg. Q = {3, 1, 2})
	private char find(char[] vva, Node root, Queue<Integer> queue){
		if (root.left == null)
			return root.bool;
		else{
			char bool = vva[queue.poll()-1];
			if (bool == '0'){
				return find(vva, root.left, queue);
			} else if (bool == '1'){
				return find(vva, root.right, queue);
			} else {
				return '\0'; // failure -> should never reach
			}
		}
	}
	
	public class Node{
		public char bool; //x if composite node, 0 or 1 if leaf
		public Node right;
		public Node left;
		
		private Node(char bool){
			this.bool = bool;
			right = null;
			left = null;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, test = 1;
		while ((n = sc.nextInt()) != 0){
			// read input
			Queue<Integer> vars = new LinkedList<Integer>();
			for (int i = 0; i < n; i++){
				vars.offer(Integer.parseInt(sc.next().replaceFirst("x", "")));
			}
			char[] leaves = sc.next().toCharArray();
			// Build Tree
			STrees tree = new STrees();
			tree.buildTree(leaves);

			// Get value of each sequence
			int vvaNum = sc.nextInt();
			String sTree = "";
			while (vvaNum > 0){
				char[] vva = sc.next().toCharArray();
				Queue<Integer> copyVars = new LinkedList<Integer>();
				copyVars.addAll(vars);
				char bool = tree.find(vva, copyVars);
				sTree += bool;
				vvaNum--;
			}
			System.out.println("S-Tree #" + (test++) + ":\n" + sTree + "\n");
		}
		sc.close();
	}
}
