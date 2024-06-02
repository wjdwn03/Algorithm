public class Test {
    long sum(int[] a) {
        long ans = 0L;

		for (int num : a) {
			ans += (long) num;
		}

		return ans;
    }
}