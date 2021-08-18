class Knapsack{

	static int max(int a,int b){
		return (a > b)? a:b;
	}

	static int Knapsack(int[] wt,int[] val,int W){
		int n = val.length;
		int [][]M = new int[n+1][W+1];

		for(int i=0;i<=n;i++){
			for(int w=0;w<=W;w++){
				
				if(i==0 || w==0)
					M[i][w] = 0;
				
				else if(wt[i-1] > w)
					M[i][w] = M[i-1][w];
				
				else
					M[i][w] = max(M[i-1][w], M[i-1][w-wt[i-1]]+val[i-1]);
			}
		}

		int i=n,k=W;
		while(i > 0 && k > 0){
			if(M[i][k] != M[i-1][k]){
				System.out.println(i+" ");
				i--;
				k = k - wt[i];
			}
			else
				i--;
		}
		return M[n][W];
	} 

	public static void main(String[] args) {
			int [] wt = {3,5,6,2};
			int [] val = {10,4,9,11};
			int W = 7;
			int res = Knapsack(wt,val,W);
			System.out.println("Optimal value of knapsack: "+res);
		}	
}