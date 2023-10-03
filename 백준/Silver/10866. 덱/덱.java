import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Deque deq = new Deque();

		String order = "";
		int num = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			order = st.nextToken();

			if (st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());

			if (order.equals("push_front")) {
				deq.addFirst(num);
				continue;
			} else if (order.equals("push_back")) {
				deq.addLast(num);
				continue;
			} else if (order.equals("pop_front")) {
				sb.append(deq.pollFirst());
			} else if (order.equals("pop_back")) {
				sb.append(deq.pollLast());
			} else if (order.equals("size")) {
				sb.append(deq.length());
			} else if (order.equals("empty")) {
				sb.append(deq.isEmpty());
			} else if (order.equals("front")) {
				sb.append(deq.peekFirst());
			} else {
				sb.append(deq.peekLast());
			} 
			sb.append("\n");
		} // end for

		System.out.println(sb.toString());
	}

	static class Deque {
		private static Node head;
		private static Node tail;
		private static int size = 0;

		// 1
		static void addFirst(int num) {

			Node newNode = new Node(num);

			if (head == null) {
				tail = newNode;
			} else {
				newNode.next = head;
				head.before = newNode;
			}
			head = newNode;
			size++;

		}

		// 2
		static void addLast(int num) {

			Node newNode = new Node(num);

			if (tail == null) {
				head = newNode;
			} else {
				tail.next = newNode;
				newNode.before = tail;
			}

			tail = newNode;
			size++;
		}

		// 3
		static int pollFirst() {
			if (size == 0) {
				return -1;
			} else {
				int ans = head.num;

				if (size > 1) {
					head = head.next;
				}
				else if(size==1) {
					head = null;
					tail = null;
				}
				
				size--;
				return ans;
			}
		}

		// 4
		static int pollLast() {
			if (size == 0)
				return -1;
			else {
				int ans = tail.num;

				if (size > 1) {
					tail = tail.before;
				}
				else if(size == 1) {
					head = null;
					tail = null;
				}

				size--;
				return ans;
			}
		}

		// 5
		static int length() {
			return size;
		}

		// 6
		static int isEmpty() {
			if (size != 0) {
				return 0;
			}
			else {
				return 1;
			}
		}

		// 7
		static int peekFirst() {
			if (size == 0) {
				return -1;
			}
			else {
				return head.num;
			}
		}

		// 8
		static int peekLast() {
			if (size == 0) {
				return -1;
			}
			else {
				return tail.num;
			}
		}
	}

	static class Node {
		int num;
		Node before;
		Node next;

		public Node(int num) {
			this.num = num;
		}
	}

}