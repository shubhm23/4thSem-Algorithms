/*		Algorithm :
		input: List of jobs with start,end and value of interval;
		output: List of optimal intervals with maximum value;

		Sort the intervals with their finishing time

		calculate latest compatible interval for each interval p1,p2,,,,pn;

		initialize for j = 0 to n
		M[j] = 0;

		M-compute-Opt(j){
			M[i] = max(M[i-1],vi + M-compute-Opt(i));
		} 

		Find_Solution(int j){
			if j=0:
				output nothing;
			else if(vj + M[p(j)] > M[j-1])
				print j
				Find_Solution(p(j))
			else
				Find_Solution(j-1)
		}

*/
import java.util.*;
class WeightedIntervalScheduling{
	private int [][] jobs;
	private int [] memo;
	private ArrayList<Integer> includedJobs = new ArrayList();
	public void calcschedule(int [][] inputjobs){
		int n = inputjobs.length;
		jobs = inputjobs;
		java.util.Arrays.sort(jobs,(a,b)->Integer.compare(a[2],b[2]));

		memo = new int[n];
		memo[0] = 0;
		for(int i=1;i<n;i++){
			memo[i] = Math.max(memo[i-1],jobs[i][3] + memo[latestCompatible(i)]);
		}

		System.out.println("Memoization array: "+ Arrays.toString(memo));
		System.out.println("Maximum profit from the optimal set of jobs:"+ memo[memo.length-1]);
		find_Solution(memo.length-1);
		for(int i=includedJobs.size()-1;i>=0;i--){
			System.out.println(getInfo(includedJobs.get(i)));
		}
	}

	private String getInfo(int i){
		return "Jobs "+jobs[i][0]+ " Time ( "+ jobs[i][1] + " - " +jobs[i][2]+" )"+ " Values: " + jobs[i][3];
			}

	private int latestCompatible(int j){
		int low = 0,high = j-1;
		while(low <= high){
			int mid = (low+high)/2;
			if (jobs[mid][2] <= jobs[j][1]) {
				if (jobs[mid + 1][2] <= jobs[j][1])
					low = mid + 1;
				else
					return mid;
			}
			else
				high = mid - 1;
		}
		return 0;
	}

	private void find_Solution(int j){
		if(j == 0)
			return ;
		else if(jobs[j][3] + memo[latestCompatible(j)] > memo[j-1]){
			includedJobs.add(j);
			find_Solution(latestCompatible(j));
		}
		else
			find_Solution(j-1);
	}

	public static void main(String[] args) {
		WeightedIntervalScheduling schedule = new WeightedIntervalScheduling();
		int [][] inputJobs = { {0,0,0,0},
							   {1,1,2,100},
							   {2,2,5,200},
							   {3,3,6,300},
							   {4,4,8,400},
							   {5,5,9,500},
							   {6,6,10,100}
							};
		schedule.calcschedule(inputJobs);
	}
}