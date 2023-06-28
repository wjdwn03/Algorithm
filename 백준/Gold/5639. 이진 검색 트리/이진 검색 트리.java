import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static BinaryTree tree; // 이진트리

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		tree = new BinaryTree();

		String n= "";
		while ((n = br.readLine()) != null) {
			
			// 빈 문자열이 들어오면  break;
			if(n.length()==0) {
				break;
			}
			int num = Integer.parseInt(n);
			

			tree.addNode(num);
		}

		// 후위순회
		postorder(tree.root);

		System.out.println(sb.toString());
	} // end main

	public static class BinaryTree {

		static Node root;

		public static void addNode(int value) {
			// 트리가 비어있다면
			if (root == null) {
				root = new Node(value); // 루트 노드 추가
			}
			// 트리가 비어있지 않은 경우
			// 노드를 추가한다.
			else {
				
				addChild(root, value);
			}

		}

		private static Node addChild(Node current, int value) {
			
			// 비어있는 노드면 거기에 노드를 추가해준다.
			if(current == null) {
				current = new Node(value);
				return current;
			}
			
			// current 노드보다 값이 작으면 current 노드의 왼쪽 자식에 추가해준다.
			if(value < current.value) {
				current.left = addChild(current.left, value);
			}
			// current 노드보다 값이 작으면 current 노드의 오른쪽 자식에 추가해준다.
			else if( value > current.value) {
				current.right = addChild(current.right, value);
			}
			
			return current;
			
		} // end addChild


	} // end BinaryTree class 
	

	// 후위순회(왼쪽자식->오른쪽자식->루트)
	public static void postorder(Node now) {

		if (now != null) {
			
			// 왼쪽 자식 노드
			if (now.left != null) {

				postorder(now.left);
			}
			
			// 오른쪽 자식 노드
			if (now.right != null) {

				postorder(now.right);
			}
			// 부모노드
			sb.append(now.value).append("\n");
		}
	}

	static class Node {

		int value;

		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}
}