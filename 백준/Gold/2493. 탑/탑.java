import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Point> stack = new Stack<>();

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek().height > num){
                    sb.append(stack.peek().idx);
                    sb.append(" ");
                    stack.push(new Point(i, num)); // stack에 일단 다 넣어준다.
                    break;
                }
                else{
                    stack.pop(); // 스택에 저장된 애보다 더 크거나 같으면 일단 뽑아
                }
            }
            if(stack.isEmpty()){ // 현재 num이 스택에 딱 한 개 들어있던 값보다 커서 pop 된 경우 여기서 걸려야 하기 때문에 이 위치에 있어야 함.
                sb.append("0 ");
                stack.push(new Point(i, num));
            }
        }

        System.out.print(sb.toString());



    } // end main

    static class Point{
        int idx, height;

        Point(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }


}