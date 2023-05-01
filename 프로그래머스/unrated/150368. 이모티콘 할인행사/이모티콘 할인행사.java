class Solution {
    
    static int count, fee;
    static int[] numbers;
	static int[] input = {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        numbers = new int[emoticons.length];
        count = 0;
        fee = 0;
        
        perm(0, users, emoticons);
        
        int[] answer = {count, fee};
        return answer;
    }
    
    	private static void perm(int cnt, int[][] users, int[] emoticons) {
		// TODO Auto-generated method stub
		
		if(cnt == emoticons.length) {
			
			int person = 0, pay = 0;
			int[] charge = new int[users.length];
			
			for(int i=0; i<users.length; i++) {
				
				int sum = 0;
				for(int j=0; j<emoticons.length; j++) {
					if(users[i][0] <= numbers[j]) {
						sum += emoticons[j] * (1-(double)numbers[j]/100);
					}
				}
				
				if(sum >= users[i][1]) {
					person++;
				}
				else {
					pay += sum;
				}
			}
			
			if(count < person) {
				count = person;
				fee = pay;
			}
			else if(count == person && fee < pay) {
				fee = pay;
			}
			
			return;
		}
		
		for(int i=0; i<input.length; i++) {
			numbers[cnt] = input[i];
			perm(cnt+1, users, emoticons);
		}
		
	}
}