import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, deleteN, cnt;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 노드의 개수
		
		list = new ArrayList[N+1]; // 하위 노드를 저장할 리스트
		cnt = 0; // 리프 노드의 개수
		
		// 초기화
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 자식 노드를 넣어준다.
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list[num+1].add(i);
		}
		
		// 삭제할 노드
		deleteN = Integer.parseInt(br.readLine())+1;
		
		// deleteN번 노드에 연결된 직속 자식을 지운다.
		list[deleteN].subList(0, list[deleteN].size()).clear();
		
		dfs(0);
		
		System.out.println(cnt);
		
		
	}

	private static void dfs(int idx) {
		
		int size = list[idx].size();
		
		// 사이즈가 0이면 리프노드라는 말이기 때문에 cnt를 1 증가시키고 리턴한다.
		if(size==0) {
			cnt++;
			return;
		}
		
		for(int i=0; i<size; i++) {
			// deleteN 직속 자식은 지웠지만 자식노드가 deleteN인 경우는 안 지웠기 때문에 그 경우엔 continue
			if(list[idx].get(i)==deleteN) {
				
				// 자식 노드가 한 개 밖에 없는데 그게 deleteN 번 노드면 이게 삭제되고 나면 list[idx].get(i)가 리프노드이다.
				// 그리고 루트 노드는 1부터 시작하는데 0부터 호출하기 때문에 0도 제외한다.
				if(size==1 && idx != 0) {
					cnt++;
				}
				continue;
			}
			dfs(list[idx].get(i));
		}
		
	}

}