import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static BinaryTree tree; // 이진트리

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		tree = new BinaryTree();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = st.nextToken().charAt(0); // parent
			int l = st.nextToken().charAt(0); // left child
			int r = st.nextToken().charAt(0); // right child

			tree.addNode(p, l, r);
		}

		preorder(tree.node);
		sb.append("\n");
		inorder(tree.node);
		sb.append("\n");
		postorder(tree.node);

		System.out.println(sb.toString());
	} // end main

	public static class BinaryTree {

		static Node node;

		public static void addNode(int value, int left, int right) {
			// 트리가 비어있다면
			if (node == null) {
				node = new Node(value); // 루트 노드 추가

				if (left != 46) { // 왼쪽 자식 노드가 있는 경우 '.' 아스키코드가 46임.
					node.left = new Node(left);
				}
				if (right != 46) { // 오른쪽 자식 노드가 있는 경우 '.' 아스키코드가 46임.
					node.right = new Node(right);
				}
			}
			// 트리가 비어있지 않은 경우
			// value 즉, value와 같은 값을 가진 노드가(부모노드임)나올 때까지 타고 내려가야 한다.
			else {
				findNode(node, value, left, right);
			}

		}

		private static void findNode(Node node, int value, int left, int right) {

			// 만약 노드가 null이라면 그냥 리턴
			if (node == null)
				return;
			// value와 같은 값을 가진 부모노드를 찾은 경우
			// 즉 자식 노드를 삽입할 부모 노드를 찾은 경우
			else if (node.value == value) {
				
				// 왼쪽 자식 노드가 있는 경우 추가한다.
				if (left != 46) {
					node.left = new Node(left);
				}
				// 오른쪽 자식 노드가 있는 경우 추가한다.
				if (right != 46) {
					node.right = new Node(right);
				}
			} 
			// node.value != value인 경우
			// 즉 자식 노드를 삽입할 부모 노드를 못 찾은 경우 더 타고 내려간다.
			else {
				findNode(node.left, value, left, right);
				findNode(node.right, value, left, right);
			}

		}

	}

	// 전위순회(루트->왼쪽자식->오른쪽자식)
	public static void preorder(Node now) {

		if (now != null) {
			// 부모노드
			sb.append((char) now.value);
			
			// 왼쪽 자식 노드
			if (now.left != null) {

				preorder(now.left);
			}
			
			// 오른쪽 자식 노드
			if (now.right != null) {

				preorder(now.right);
			}
		}
	}

	// 중위순회(왼쪽자식->루트->오른쪽자식)
	public static void inorder(Node now) {

		if (now != null) {
			
			// 왼쪽 자식 노드
			if (now.left != null) {

				inorder(now.left);
			}
			
			// 부모노드
			sb.append((char) now.value);
			
			// 오른쪽 자식 노드
			if (now.right != null) {

				inorder(now.right);
			}
		}
	}

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
			sb.append((char) now.value);
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