public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[10001];

		for (int i = 1; i <= 10000; i++) {
			int num = i;

			if (arr[num] == 1)
				continue;

			while (num <= 10000) {
				int tmp = num;

				while (num > 0) {
					tmp += num % 10;
					num /= 10;
				}

				if (tmp >= 10000 || arr[tmp] == 1)
					break;

				arr[tmp] = 1;
				num = tmp;
			}
		}

		for (int i = 1; i < 10000; i++) {
			if (arr[i] == 1)
				continue;
			sb.append(i).append("\n");
		}

		System.out.println(sb.toString());
	}

}