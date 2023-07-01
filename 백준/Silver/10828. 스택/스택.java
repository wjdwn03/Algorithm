import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		
		int size=0;

		for (int t = 0; t < T; t++) {

			String order = br.readLine();

			if (order.contains("push")) {
				stack.add(Integer.parseInt(order.substring(5)));
				size++;
			} else if (order.contains("pop")) {
				if (size==0) {
					bw.write("-1");
				} else {
					bw.write(String.valueOf(stack.pop()));
					size--;
				}
				bw.newLine();
			} else if (order.contains("size")) {
				bw.write(String.valueOf(size));
				bw.newLine();
			} else if (order.contains("empty")) {
				if (size==0) {
					bw.write("1");
				} else {
					bw.write("0");
				}
				bw.newLine();
			} else if (order.contains("top")) {
				if (size==0) {
					bw.write("-1");
				} else {
					bw.write(String.valueOf(stack.peek()));
				}
				bw.newLine();
			}
		} // end for t
		
		bw.flush();
		bw.close();
	} // end main

}